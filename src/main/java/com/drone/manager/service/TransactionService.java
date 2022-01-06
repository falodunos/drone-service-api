package com.drone.manager.service;


import com.drone.manager.controller.DispatchController;
import com.drone.manager.dto.request.GetDroneByItemDTO;
import com.drone.manager.dto.request.LoadItemDTO;
import com.drone.manager.exception.MissingEntityException;
import com.drone.manager.model.Drone;
import com.drone.manager.model.Medication;
import com.drone.manager.model.Transaction;
import com.drone.manager.model.enums.DroneState;
import com.drone.manager.model.enums.MedicationState;
import com.drone.manager.model.enums.constraints.DroneStateValueSubset;
import com.drone.manager.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    DroneService droneService;

    @Autowired
    MedicationService medicationService;

    public Drone getDroneByLoadedItem(GetDroneByItemDTO.Request.Body request) {

        Optional<Transaction> optionalTransaction = transactionRepository.findByPackageReferenceAndMedicationCode(request.getPackageReference(), request.getMedicationCode());
        Drone drone = null;
        Transaction transaction = null;
        if (optionalTransaction.isPresent()) {
            transaction = optionalTransaction.get();
            Optional<Drone> optionalDrone = droneService.getDroneBySerialNumber(transaction.getDroneSn());
            if (optionalDrone.isPresent()) {
                drone = optionalDrone.get();
            }
        }
        if (transaction != null){
            logger.info("Transaction :: {}" + transaction);
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

            Optional<Drone> optionalDrone = droneService.getDroneBySerialNumber(request.getDroneSerialNumber());
            Drone drone = optionalDrone.isPresent() ? optionalDrone.get() : null;

            // Only medication in either resting or delivered state can be loaded
            // A drone can be loaded when it is either in loading or idle state

            if (drone != null && (drone.getState().equals(DroneState.IDLE) || drone.getState().equals(DroneState.LOADING)))
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
