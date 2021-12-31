package com.drone.manager.model.enums;

public enum DroneState {
    IDLE("idle"), LOADING("loading"), LOADED("loaded"), DELIVERING("delivering"),
    DELIVERED("delivered"), RETURNING("returning");

    private String code;

    DroneState(String code) { this.code = code; }

    public String getCode() {
        return code;
    }
}

