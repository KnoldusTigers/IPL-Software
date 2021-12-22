package com.validations;

import javax.validation.*;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Constraint(validatedBy = {TeamValidator.class })
    public @interface MatchValidation {

        String message() default "team1 or team2 not be equal!";

        Class<?>[] groups() default { };

        Class<? extends Payload>[] payload() default { };

    }

