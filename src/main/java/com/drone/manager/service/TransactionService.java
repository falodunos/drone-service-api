package com.drone.manager.service;


import com.drone.manager.dto.request.GetDroneByItemDTO;
import com.drone.manager.dto.request.LoadItemDTO;
import com.drone.manager.exception.MissingEntityException;
import com.drone.manager.model.Drone;
import com.drone.manager.model.Medication;
import com.drone.manager.model.Transaction;
import com.drone.manager.model.enums.MedicationState;
import com.drone.manager.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TransactionService extends BaseService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    DroneService droneService;

    @Autowired
    MedicationService medicationService;

    public Drone getDroneByLoadedItem(GetDroneByItemDTO.Request.Body request) {

        Optional<Transaction> optionalTransaction = transactionRepository.findByPackageReferenceAndMedicationCode(request.getPackageReference(), request.getMedicationCode());
        Drone drone = null;
        if (optionalTransaction.isPresent()) {
            Transaction transaction = optionalTransaction.get();
            Optional<Drone> optionalDrone = droneService.getDroneBySerialNumber(transaction.getDroneSn());
            if (optionalDrone.isPresent()) {
                drone = optionalDrone.get();
            }
        }
        if (drone != null) {
            return drone;
        }

        throw new MissingEntityException("Drone loading item with medication code '" + request.getMedicationCode() +
                "' and package reference '" + request.getPackageReference() + "' Not Found!");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Long> loadDroneWithItems(LoadItemDTO.Request.Body request) {

        List<Transaction> transactionList = new ArrayList<>();
        List<Long> transactionIds = new ArrayList<>();

        for (LoadItemDTO.ItemDTO.Request.Default item : request.getItems()) {
            Optional<Medication> optionalMedication = medicationService.getMedicationByCode(item.getMedicationCode());

            Medication medication = optionalMedication.isPresent() ? optionalMedication.get() : null;

            // Only medication in either resting or delivered state can be loaded

            if (medication != null && (medication.getState().equals(MedicationState.RESTING)
                    || medication.getState().equals(MedicationState.DELIVERED))) {
                Transaction transaction = new Transaction();
                transaction.setDroneSn(request.getDroneSerialNumber());
                transaction.setPackageReference(request.getPackageReference());
                transaction.setMedicationCode(item.getMedicationCode());
                transactionList.add(transaction);
            }
        }

        transactionList = transactionRepository.saveAll(transactionList);

        for (Transaction transaction : transactionList)
            transactionIds.add(transaction.getId());

        return transactionIds;
    }

}
