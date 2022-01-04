package com.drone.manager.service;

import com.drone.manager.dto.request.MedicationDataDTO;
import com.drone.manager.exception.DuplicateUniqueIdException;
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

    /**
     * @param request
     * @return Optional
     */
    public Optional<Medication> save(MedicationDataDTO.Request.Body request) {

        Optional<Medication> optionalMedication = this.medicationRepository.findByCode(request.getCode());

        if (!optionalMedication.isPresent()) {
            Medication medication = new Medication(request.getName(), request.getWeight(), request.getCode(), request.getImagePath(), request.getState());

            medication = this.medicationRepository.save(medication);
            return Optional.of(medication);
        }

        throw new DuplicateUniqueIdException("A medication with code '" + request.getCode() + "' already exist!");
    }
}
