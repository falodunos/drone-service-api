package com.drone.manager.model.enums.state;

import com.drone.manager.model.enums.DroneState;
import com.drone.manager.model.enums.MedicationState;
import com.drone.manager.model.enums.constraints.MedicationStateValueSubset;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class MedicationStateValueSubsetValidator implements ConstraintValidator<MedicationStateValueSubset, MedicationState> {
    private DroneState[] subset;

    /**
     * @param constraint
     */
    @Override
    public void initialize(MedicationStateValueSubset constraint) {
        this.subset = constraint.anyOf();
    }


    /**
     * @param hasDroneState
     * @param context
     * @return boolean
     */
    @Override
    public boolean isValid(MedicationState hasDroneState, ConstraintValidatorContext context) {
        return hasDroneState == null || Arrays.asList(subset)
                .contains(hasDroneState);
    }
}