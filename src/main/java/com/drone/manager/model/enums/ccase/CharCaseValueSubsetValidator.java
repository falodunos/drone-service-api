package com.drone.manager.model.enums.ccase;

import com.drone.manager.model.enums.CharCase;
import com.drone.manager.model.enums.constraints.CharCaseValueSubset;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class CharCaseValueSubsetValidator implements ConstraintValidator<CharCaseValueSubset, CharCase> {
    private CharCase[] subset;

    /**
     * @param constraint
     */
    @Override
    public void initialize(CharCaseValueSubset constraint) {
        this.subset = constraint.anyOf();
    }


    /**
     * @param hasCase
     * @param context
     * @return boolean
     */
    @Override
    public boolean isValid(CharCase hasCase, ConstraintValidatorContext context) {
        return hasCase == null || Arrays.asList(subset)
                .contains(hasCase);
    }
}