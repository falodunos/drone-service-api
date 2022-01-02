package com.drone.manager.service;

import com.drone.manager.model.Medication;
import com.drone.manager.repository.MedicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class MedicationService extends BaseService {
    @Autowired
    MedicationRepository medicationRepository;

    /**
     * @param medicationCode
     * @return Optional
     */
    public Optional<Medication> getMedicationByCode(String medicationCode) {
        return this.medicationRepository.findByCode(medicationCode);
    }

}
