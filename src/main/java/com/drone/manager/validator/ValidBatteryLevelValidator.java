package com.drone.manager.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class ValidBatteryLevelValidator implements ConstraintValidator<ValidBatteryLevel, Double> {

    public ValidBatteryLevelValidator() {
    }

    /**
     * @param constraint
     */
    public void initialize(ValidBatteryLevel constraint) {
    }

    /**
     * @param
     * @param validatorContext
     * @return boolean
     */
    @Override
    public boolean isValid(Double batteryCapacity, ConstraintValidatorContext validatorContext) {

        boolean isLessThanOrEqualToOneInPercentage = Integer.parseInt(String.valueOf(batteryCapacity)) <= 1;
        boolean isGreaterThanOrEqualTo25Percent = (int) (batteryCapacity * 100) >= 25;

        return  isLessThanOrEqualToOneInPercentage && isGreaterThanOrEqualTo25Percent;
    }
}