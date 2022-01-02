package com.drone.manager.model.enums.ccase;

import com.drone.manager.model.enums.CharCase;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class CharCaseValueConverter implements AttributeConverter<CharCase, String> {
    /**
     * @param status
     * @return String
     */
    @Override
    public String convertToDatabaseColumn(CharCase status) {
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
    public CharCase convertToEntityAttribute(final String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(CharCase.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}