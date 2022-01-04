package com.drone.manager.service;

import com.drone.manager.dto.request.DroneDataDTO;
import com.drone.manager.exception.DuplicateUniqueIdException;
import com.drone.manager.exception.MissingEntityException;
import com.drone.manager.model.Drone;
import com.drone.manager.repository.DroneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DroneService extends BaseService {
    @Autowired
    DroneRepository droneRepository;


    /**
     * @param request
     * @return Optional
     */
    public Optional<Drone> save(DroneDataDTO.Request.Body request) {

        Optional<Drone> optionalDrone = this.droneRepository.findBySerialNumber(request.getSerialNumber());

        if (!optionalDrone.isPresent()) {
            Drone drone = new Drone(request.getSerialNumber(), request.getModel(), request.getWeightLimit(), request.getBatteryCapacity(), request.getState());
            drone.setCreatedAt(new Date());
            drone.setUpdatedAt(new Date());
            drone = this.droneRepository.save(drone);
            return Optional.of(drone);
        }

        throw new DuplicateUniqueIdException("A drone with serial number '" + request.getSerialNumber() + "' already exist!");
    }

    /**
     * @param droneId
     * @return Optional
     */
    public Optional<Drone> getDroneById(Long droneId) {
        return this.droneRepository.findById(droneId);
    }

    /**
     * @param sn
     * @return Optional
     */
    public Optional<Drone> getDroneBySerialNumber(String sn) {
        return this.droneRepository.findBySerialNumber(sn);
    }

    /**
     *
     * @return List<Drone>
     */
    public List<Drone> findAllDrones() {
        return this.droneRepository.findAll();
    }

    /**
     *
     * @return List<Drone>
     */
    public List<Drone> findAvailableDrones() {
        return this.droneRepository.findAvailableDrones();
    }

    /**
     * @return
     */
    public double getDroneBatteryLevel(Long id) {
        Optional<Drone> optionalDrone = this.droneRepository.findById(id);
        Drone drone = null;
        if (optionalDrone.isPresent()) {
            drone = optionalDrone.get();
            return drone.getBatteryCapacity();
        }

        throw new MissingEntityException("Drone With ID '" + id + "' Not Found!");

    }

    /**
     * @return
     */
    public double getDroneBatteryLevel(String sn) {
        Optional<Drone> optionalDrone = this.droneRepository.findBySerialNumber(sn);
        Drone drone;
        if (optionalDrone.isPresent()) {
            drone = optionalDrone.get();
            return drone.getBatteryCapacity();
        }

        throw new MissingEntityException("Drone With Serial Number '" + sn + "' Not Found!");
    }
}
