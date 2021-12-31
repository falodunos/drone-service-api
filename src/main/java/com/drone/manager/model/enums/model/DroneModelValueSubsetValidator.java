package com.drone.manager.model.enums.model;

import com.drone.manager.model.enums.DroneModel;
import com.drone.manager.model.enums.constraints.DroneModelValueSubset;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class DroneModelValueSubsetValidator implements ConstraintValidator<DroneModelValueSubset, DroneModel> {
    private DroneModel[] subset;

    /**
     * @param constraint
     */
    @Override
    public void initialize(DroneModelValueSubset constraint) {
        this.subset = constraint.anyOf();
    }


    /**
     * @param hasDroneModel
     * @param context
     * @return boolean
     */
    @Override
    public boolean isValid(DroneModel hasDroneModel, ConstraintValidatorContext context) {
        return hasDroneModel == null || Arrays.asList(subset)
                .contains(hasDroneModel);
    }
}