package com.drone.manager.repository;

import com.drone.manager.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Integer>, JpaSpecificationExecutor<Medication> {
    /**
     * @param code
     * @return Optional
     */
    Optional<Medication> findByCode(String code);
}
