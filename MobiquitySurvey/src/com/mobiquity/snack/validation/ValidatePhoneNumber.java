package com.mobiquity.snack.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatePhoneNumber implements ConstraintValidator<PhoneNumberValidator, Long> {
    private static final String PHONE_PATTERN = "\\d{10}";

    @Override
    public void initialize(PhoneNumberValidator arg0) {
       

    }

    @Override
    public boolean isValid(Long phoneNumber, ConstraintValidatorContext arg1) {
        String phoneString = Long.toString(phoneNumber);
        System.out.println(phoneString);
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(phoneString);
        if (!matcher.matches()) {
            System.out.println("----------------------------pattern does not matches");
            return false;
        } else {
            System.out.println("----------------------------pattern does  matches");
            return true;
        }
    }

}
