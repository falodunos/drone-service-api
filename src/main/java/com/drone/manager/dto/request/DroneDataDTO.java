package com.drone.manager.dto.request;

import com.drone.manager.model.enums.DroneModel;
import com.drone.manager.model.enums.DroneState;
import com.drone.manager.model.enums.constraints.DroneModelValueSubset;
import com.drone.manager.model.enums.constraints.DroneStateValueSubset;
import com.drone.manager.validator.ValidBatteryLevel;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.drone.manager.validator.ValidWeight;

public enum DroneDataDTO {;
    private interface SerialNumber {
        /**
         * Serial number uniquely identifying a drone
         * Not more than 100 characters.
         * @return String
         */
        @NotBlank(message = "Please provide a valid serial number ")
        @Size(max = 100, message = "Invalid serial number, length cannot be greater 100")
        String getSerialNumber();
    }

    private interface Model {
        /**
         * Model identifying a drone type or model
         *
         * @return DroneModel
         */
        @DroneModelValueSubset(anyOf = { DroneModel.CRUISERWEIGHT, DroneModel.HEAVYWEIGHT, DroneModel.LIGHTWEIGHT, DroneModel.MIDDLEWEIGHT })
        DroneModel getModel();
    }

    private interface WeightLimit {
        /**
         * Drone weight limit
         *
         * @return string
         */
        @NotBlank(message = "Please provide a valid drone weight limit")
        @ValidWeight
        String getWeightLimit();
    }

    private interface BatteryCapacity {
        /**
         * Drone battery capacity
         *
         * @return String
         */
        @NotBlank(message = "Please provide a valid drone battery capacity")
        @ValidBatteryLevel
        String getBatteryCapacity();
    }

    private interface State {
        /**
         * Drone state
         *
         * @return DroneState
         */
        @DroneStateValueSubset(anyOf = { DroneState.IDLE, DroneState.DELIVERED, DroneState.DELIVERING,
                DroneState.LOADED, DroneState.LOADING, DroneState.RETURNING})
        DroneState getState();
    }

    public enum Request {
        ;
        @Value
        public static class Body implements SerialNumber, Model, WeightLimit, BatteryCapacity, State {
            String serialNumber;
            DroneModel model;
            String weightLimit;
            Double batteryCapacity;
            DroneState state;
        }
    }
}