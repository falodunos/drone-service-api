package com.drone.manager.dto.request;

import com.drone.manager.model.enums.MedicationState;
import com.drone.manager.model.enums.constraints.MedicationStateValueSubset;
import com.drone.manager.validator.ValidWeight;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public enum MedicationDataDTO {;
    private interface Name {
        /**
         * name (allowed only letters, numbers, ‘-‘, ‘_’);
         * @return String
         */
        @NotBlank(message = "Please provide a valid medication name ")
        @Pattern(regexp = "^[a-zA-Z0-9_-]*$", message = "Name must contain only letters, " +
                "numbers, hyphen(-) or underscore (_)")
        String getName();
    }

    private interface Weight {
        /**
         * Model identifying a drone type or model
         *
         * @return String
         */
        @NotBlank(message = "Please provide a valid medication weight limit")
        @ValidWeight
        String getWeight();
    }

    private interface Code {
        /**
         * code (allowed only upper case letters, underscore and numbers);
         *
         * @return String
         */
        @NotBlank(message = "Please provide a valid medication code")
        @Pattern(regexp = "^[A-Z0-9_]*$", message = "Code must contain only uppercase letters, underscore (_) and numbers")
        String getCode();
    }

    private interface Image {
        /**
         * image (picture of the medication case).
         *
         * @return DroneState
         */
        @NotNull(message = "Please provide a valid image file")
        ImageDTO.Default getImage();
    }

    public enum ImageDTO {;
        @NotBlank(message = "Please provide a valid image file name")
        private interface FileName {
            String getFileName();
        }
        @NotBlank(message = "Please provide a valid image file upload url")
        private interface FileDownloadUrl {
            String getFileDownloadUrl();
        }
        @NotBlank(message = "Please provide a valid image file type")
        private interface FileType {
            String getFileType();
        }
        @NotBlank(message = "Please provide a valid image file size")
        private interface Size {
            int getSize();
        }

        @Value
        public static class Default implements FileName, FileDownloadUrl, FileType, Size {
            String fileName;
            String fileDownloadUrl;
            String fileType;
            int size;
        }
    }

    private interface State {
        /**
         * Drone state
         *
         * @return DroneState
         */
        @NotNull(message = "Please provide a valid medication state")
        @MedicationStateValueSubset(anyOf = { MedicationState.DISPATCHED, MedicationState.INTRANSIT, MedicationState.DELIVERED})
        MedicationState getState();
    }

    public enum Request {
        ;
        @Value
        public static class Body implements Name, Weight, Code, Image, State {
            String name;
            String weight;
            String code;
            ImageDTO.Default image;
            MedicationState state;
        }
    }
}