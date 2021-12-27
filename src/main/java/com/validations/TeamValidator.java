package com.validations;

import com.model.MatchModel;
import com.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The type Team validator.
 */
public class TeamValidator implements ConstraintValidator<MatchValidation, MatchModel> {
    @Autowired
    public ResultService rs;
    @Override
    public void initialize( final MatchValidation constraintAnnotation) {
        // comment method

    }
    @Override
    public boolean isValid(final MatchModel value, final ConstraintValidatorContext context) {

        return value.getTeam1() != value.getTeam2();

    }
}