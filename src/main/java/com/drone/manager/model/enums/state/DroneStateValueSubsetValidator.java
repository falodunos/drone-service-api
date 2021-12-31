package com.drone.manager.model.enums.state;

import com.drone.manager.model.enums.DroneModel;
import com.drone.manager.model.enums.DroneState;
import com.drone.manager.model.enums.constraints.DroneModelValueSubset;
import com.drone.manager.model.enums.constraints.DroneStateValueSubset;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class DroneStateValueSubsetValidator implements ConstraintValidator<DroneStateValueSubset, DroneState> {
    private DroneState[] subset;

    /**
     * @param constraint
     */
    @Override
    public void initialize(DroneStateValueSubset constraint) {
        this.subset = constraint.anyOf();
    }


    /**
     * @param hasDroneState
     * @param context
     * @return boolean
     */
    @Override
    public boolean isValid(DroneState hasDroneState, ConstraintValidatorContext context) {
        return hasDroneState == null || Arrays.asList(subset)
                .contains(hasDroneState);
    }
}