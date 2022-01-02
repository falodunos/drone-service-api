package com.drone.manager.validator;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidator;

class ValidWeightValidator implements ConstraintValidator<ValidWeight, String> {

    public ValidWeightValidator() {
    }

    /**
     * @param constraint
     */
    public void initialize(ValidWeight constraint) {
    }

    /**
     * @param
     * @param validatorContext
     * @return boolean
     */
    @Override
    public boolean isValid(String weight, ConstraintValidatorContext validatorContext) {

        boolean isValid = false;
        boolean isValidLength = weight!= null ? weight.length() == 5 : false; // 500gr
        boolean isValidValue = weight != null && isValidLength ? Integer.parseInt(weight.substring(0,3)) <= 500 &&
                weight.substring(3,5).equalsIgnoreCase("gr") : false;

        isValid = isValidLength && isValidValue;

        return isValid;
    }
}