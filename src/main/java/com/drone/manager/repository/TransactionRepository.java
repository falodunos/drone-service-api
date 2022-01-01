package com.drone.manager.repository;

import com.drone.manager.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {

    /**
     * @param transactionId
     * @return Optional
     */
    Optional<Transaction> findById(Long transactionId);


    /**
     * @param id
     * @return Optional
     */
    Optional<Transaction> findByMedicationId(String id);

    /**
     * @param reference
     * @return Optional
     */
    Optional<Transaction> findByPackageReference(String reference);

    /**
     * @param reference
     * @return Optional
     */
    @Query(value = "SELECT * FROM transaction t WHERE t.package_reference = ?1 AND t.medication_id = ?2", nativeQuery = true)
    List<Transaction> findByPackageReferenceAndMedicationId(String reference, String medicationId);
}