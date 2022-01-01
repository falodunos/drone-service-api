package com.drone.manager.repository;

import com.drone.manager.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long>, JpaSpecificationExecutor<Drone> {

    /**
     * @param droneId
     * @return Optional
     */
    Optional<Drone> findById(Long droneId);


    /**
     * @param sn
     * @return Optional
     */
    Optional<Drone> findBySerialNumber(String sn);

    @Query(value = "SELECT * FROM drone d WHERE d.state = 'IDLE'", nativeQuery = true)
    List<Drone> findAvailableDrones();
}
