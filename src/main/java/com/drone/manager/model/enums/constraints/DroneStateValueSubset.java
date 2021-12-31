package com.drone.manager.model.enums.constraints;

import com.drone.manager.model.enums.DroneState;
import com.drone.manager.model.enums.state.DroneStateValueSubsetValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = DroneStateValueSubsetValidator.class)
public @interface DroneStateValueSubset {
    /**
     * @return subset of DroneState enum
     */
    DroneState[] anyOf();

    /**
     * @return the error message template
     */
    String message() default "Drone state must be any of {anyOf}";

    /**
     * @return the groups the constraint belongs to
     */
    Class<?>[] groups() default {};

    /**
     * @return the payload associated to the constraint
     */
    Class<? extends Payload>[] payload() default {};
}