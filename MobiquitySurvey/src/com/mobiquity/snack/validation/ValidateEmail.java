package com.mobiquity.snack.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateEmail implements ConstraintValidator<EmailValidator, String> {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "mobiquityinc.com";
    

    @Override
    public void initialize(EmailValidator arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext arg1) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            return false;
        } else
            return true;
    }

}
