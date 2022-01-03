package com.drone.manager.validator;

import com.drone.manager.dto.request.LoadItemDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

class ValidWeightListValidator implements ConstraintValidator<ValidWeightList, List<LoadItemDTO.ItemDTO.Request.Default>> {

    public ValidWeightListValidator() {
    }

    /**
     * @param constraint
     */
    public void initialize(ValidWeightList constraint) {
    }

    /**
     * @param
     * @param validatorContext
     * @return boolean
     */
    @Override
    public boolean isValid(List<LoadItemDTO.ItemDTO.Request.Default> items, ConstraintValidatorContext validatorContext) {

        boolean isValid = false, isValidLength, isValidValue;

        for (LoadItemDTO.ItemDTO.Request.Default item : items) {

            String weight = item.getWeight();
            isValidLength = weight!= null ? weight.length() == 5 : false; // 500gr
            isValidValue = weight != null && isValidLength ? Integer.parseInt(weight.substring(0,3)) <= 500 &&
                    weight.substring(3,5).equalsIgnoreCase("gr") : false;

            isValid = isValidLength && isValidValue;
            if (!isValid) break;
        }

        return isValid;
    }
}