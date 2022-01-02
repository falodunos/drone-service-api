package com.drone.manager.dto.request;

import com.drone.manager.validator.ValidWeight;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public enum LoadItemDTO {;
    private interface MedicationCode {
        /**
         * code (allowed only upper case letters, underscore and numbers);
         * @return String
         */
        @NotBlank(message = "Please provide a valid value, medication code cannot be empty")
        @Pattern(regexp = "^[A-Z0-9_]*$", message = "Code must contain only uppercase letters, underscore (_) and numbers")
        String getMedicationCode();
    }

    private interface Weight {
        /**
         * Drone weight limit
         *
         * @return string
         */
        @ValidWeight
        String getWeight();
    }

    public enum Request {
        ;
        @Value
        public static class Body implements MedicationCode, Weight {
            String medicationCode;
            String weight;
        }
    }
}