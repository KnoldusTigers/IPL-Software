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
    private ResultService rs;
    public void initialize(MatchValidation constraintAnnotation) {

    }

    public boolean isValid(MatchModel value, ConstraintValidatorContext context) {
        boolean valid = true;

        if (value.getTeam1() == value.getTeam2()) {
            {
                valid = false;
            }
        }
        MatchModel pointModel=new MatchModel();
        if(value.getVenue() == pointModel.getVenue()) {
            valid=false;
        }
        return valid;
    }
}