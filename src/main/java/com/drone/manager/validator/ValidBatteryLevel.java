package com.drone.manager.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidBatteryLevelValidator.class)
public @interface ValidBatteryLevel {

    String message() default "{com.drone.battery.level.validator.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}