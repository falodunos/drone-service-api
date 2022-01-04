package com.drone.manager.service;


import com.drone.manager.dto.request.GetDroneByItemDTO;
import com.drone.manager.exception.MissingEntityException;
import com.drone.manager.model.Drone;
import com.drone.manager.model.Transaction;
import com.drone.manager.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class TransactionService extends BaseService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    DroneService droneService;

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

}
