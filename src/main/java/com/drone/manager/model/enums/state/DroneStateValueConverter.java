package com.drone.manager.model.enums.state;

import com.drone.manager.model.enums.DroneModel;
import com.drone.manager.model.enums.DroneState;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class DroneStateValueConverter implements AttributeConverter<DroneState, String> {
    /**
     * @param status
     * @return String
     */
    @Override
    public String convertToDatabaseColumn(DroneState status) {
        if (status == null) {
            return null;
        }
        return status.getCode();
    }

    /**
     * @param code
     * @return DroneState
     */
    @Override
    public DroneState convertToEntityAttribute(final String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(DroneState.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}