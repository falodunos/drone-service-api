package com.drone.manager.service;

import com.drone.manager.model.Drone;
import com.drone.manager.model.DroneHistory;
import com.drone.manager.repository.DroneHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Configuration
@EnableScheduling

public class CronService {
    @Autowired
    DroneService droneService;

    @Autowired
    DroneHistoryRepository droneHistoryRepository;


    @Scheduled(fixedDelay = 30000, initialDelay = 5000)
    public void scheduleFixedRateWithInitialDelayTask() throws ExecutionException, InterruptedException {

        List<Drone> drones = this.droneService.findAllDrones(); // get all services
        checkBatteryLevel(drones); // test if services are active or inactive
        long now = System.currentTimeMillis() / 1000;
        System.out.println("Fixed rate task with one second initial delay - " + now);
    }


    private void checkBatteryLevel(List<Drone> droneList) {
        List<DroneHistory> droneHistories = new ArrayList<>();

        for (Drone drone : droneList) {
            DroneHistory droneHistory = new DroneHistory();
            droneHistory.setBatteryCapacity(drone.getBatteryCapacity());
            droneHistory.setModel(drone.getModel());
            droneHistory.setSerialNumber(drone.getSerialNumber());
            droneHistory.setWeightLimit(drone.getWeightLimit());
            droneHistories.add(droneHistory);
        }

        droneHistoryRepository.saveAll(droneHistories);
    }
}
