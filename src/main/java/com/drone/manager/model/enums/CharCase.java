package com.drone.manager.model.enums;

public enum CharCase {
    UPPER_CASE("uppercase"), LOWER_CASE("lowercase"), MIX_CASE("mixcase");

    private String code;

    CharCase(String code) { this.code = code; }

    public String getCode() {
        return code;
    }
}

