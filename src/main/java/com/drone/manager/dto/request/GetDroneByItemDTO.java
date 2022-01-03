package com.drone.manager.dto.request;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public enum GetDroneByItemDTO {;
    private interface PackageReference {
        /**
         * code (allowed only upper case letters, underscore and numbers);
         * @return String
         */
        @NotBlank(message = "Please provide a valid value, package reference cannot be empty")
        @Pattern(regexp = "^[A-Z0-9_]*$", message = "Reference must contain only uppercase letters, underscore (_) and numbers")
        String getPackageReference();
    }

    private interface MedicationCode {
        /**
         * code (allowed only upper case letters, underscore and numbers);
         *
         * @return String
         */
        @NotBlank(message = "Please provide a valid medication code")
        @Pattern(regexp = "^[A-Z0-9_]*$", message = "Code must contain only uppercase letters, underscore (_) and numbers")
        String getMedicationCode();
    }

    public enum Request {
        ;
        @Value
        public static class Body implements PackageReference, MedicationCode {
            String packageReference;
            String medicationCode;
        }
    }
}