package com.drone.manager.model.enums.constraints;

import com.drone.manager.model.enums.CharCase;
import com.drone.manager.model.enums.DroneModel;
import com.drone.manager.model.enums.model.DroneModelValueSubsetValidator;

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
@Constraint(validatedBy = DroneModelValueSubsetValidator.class)
public @interface CharCaseValueSubset {
    /**
     * @return subset of DroneModel enum
     */
    CharCase[] anyOf();

    /**
     * @return the error message template
     */
    String message() default "Char case must be any of {anyOf}";

    /**
     * @return the groups the constraint belongs to
     */
    Class<?>[] groups() default {};

    /**
     * @return the payload associated to the constraint
     */
    Class<? extends Payload>[] payload() default {};
}