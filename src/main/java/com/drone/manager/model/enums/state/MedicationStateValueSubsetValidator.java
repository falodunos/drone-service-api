package com.drone.manager.model.enums.state;

import com.drone.manager.model.enums.MedicationState;
import com.drone.manager.model.enums.constraints.MedicationStateValueSubset;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class MedicationStateValueSubsetValidator implements ConstraintValidator<MedicationStateValueSubset, MedicationState> {
    private MedicationState[] subset;

    /**
     * @param constraint
     */
    @Override
    public void initialize(MedicationStateValueSubset constraint) {
        this.subset = constraint.anyOf();
    }


    /**
     * @param hasMedicationState
     * @param context
     * @return boolean
     */
    @Override
    public boolean isValid(MedicationState hasMedicationState, ConstraintValidatorContext context) {
        return hasMedicationState == null || Arrays.asList(subset)
                .contains(hasMedicationState);
    }
}