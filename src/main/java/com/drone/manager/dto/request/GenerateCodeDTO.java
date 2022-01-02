package com.drone.manager.dto.request;

import lombok.Value;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

public enum GenerateCodeDTO {;
    private interface CodeLength {
        /**
         * the length of the code to be generated ...
         * @return String
         */
        @NotNull(message = "Please provide a valid value, code length  cannot be empty")
        @NumberFormat
        @Min(value = 5, message = "Please code length cannot be less than 5")
        @Max(value = 100, message = "Please code length cannot be greater than 100")
        int getCodeLength();
    }

    private interface CodeCount {
        /**
         * the number of codes to be generated
         *
         * @return string
         */
        @NotNull(message = "Please provide a valid value, code code  cannot be empty")
        @NumberFormat
        @Min(value = 1, message = "Please you must generate at lease one code")
        @Max(value = 10, message = "Please you cannot generated more than 10 codes per time")

        int getCodeCount();
    }

    public enum Request {
        ;
        @Value
        public static class Body implements CodeLength, CodeCount {
            int codeLength;
            int codeCount;
        }
    }
}