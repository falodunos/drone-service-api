package com.drone.manager.model.enums;

public enum MedicationState {
     DISPATCHED("dispatched"), INTRANSIT("intransit"), DELIVERED("delivered"), ;

    private String code;

    MedicationState(String code) { this.code = code; }

    public String getCode() {
        return code;
    }
}

