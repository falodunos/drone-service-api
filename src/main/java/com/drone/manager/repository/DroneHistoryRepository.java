package com.drone.manager.repository;

import com.drone.manager.model.Drone;
import com.drone.manager.model.DroneHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DroneHistoryRepository extends JpaRepository<DroneHistory, Long>, JpaSpecificationExecutor<Drone> {

    /**
     * @param droneId
     * @return Optional
     */
    Optional<DroneHistory> findById(Long droneId);


}
