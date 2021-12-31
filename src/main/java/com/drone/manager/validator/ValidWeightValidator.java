package com.drone.manager.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class ValidWeightValidator implements ConstraintValidator<ValidBank, String> {

    public ValidWeightValidator() {
    }

    /**
     * @param constraint
     */
    public void initialize(ValidBank constraint) {
    }

    /**
     * @param
     * @param validatorContext
     * @return boolean
     */
    @Override
    public boolean isValid(String weight, ConstraintValidatorContext validatorContext) {

        boolean isValid = false;
        boolean isValidLenght = weight.length() == 5; // 500gr
        boolean isValidValue = Integer.parseInt(weight.substring(0,3)) <= 500 &&
                weight.substring(3,5).toLowerCase() == "gr";

        isValid = isValidLenght && isValidValue;

        return isValid;
    }
}