package com.drone.manager.service;

import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseService {

    private static int sequence = 0;

    public static void logTransaction() {
    }

    /**
     * @param json
     * @return boolean
     */
    public boolean isValidJson(String json) {
        boolean status = true;
        try {
            JsonParser.parseString(json);
        } catch (JsonSyntaxException | JsonIOException exception) {
            status = false;
        }
        return status;
    }
}
