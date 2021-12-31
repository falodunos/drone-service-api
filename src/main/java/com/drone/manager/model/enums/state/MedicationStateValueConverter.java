package com.drone.manager.model.enums.state;

import com.drone.manager.model.enums.MedicationState;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class MedicationStateValueConverter implements AttributeConverter<MedicationState, String> {
    /**
     * @param status
     * @return String
     */
    @Override
    public String convertToDatabaseColumn(MedicationState status) {
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
    public MedicationState convertToEntityAttribute(final String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(MedicationState.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}