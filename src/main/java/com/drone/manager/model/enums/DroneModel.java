package com.drone.manager.model.enums;

public enum DroneModel {
    LIGHTWEIGHT("lightweight"), MIDDLEWEIGHT("Middleweight"), CRUISERWEIGHT("cruiserweight"),
    HEAVYWEIGHT("heavyweight");

    private String code;

    DroneModel(String code) { this.code = code; }

    public String getCode() {
        return code;
    }
}

