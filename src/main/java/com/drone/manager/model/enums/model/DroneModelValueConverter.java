package com.drone.manager.model.enums.model;

import com.drone.manager.model.enums.DroneModel;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class DroneModelValueConverter implements AttributeConverter<DroneModel, String> {
    /**
     * @param status
     * @return String
     */
    @Override
    public String convertToDatabaseColumn(DroneModel status) {
        if (status == null) {
            return null;
        }
        return status.getCode();
    }

    /**
     * @param code
     * @return GiveValue
     */
    @Override
    public DroneModel convertToEntityAttribute(final String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(DroneModel.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}