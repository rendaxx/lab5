package com.rendaxx.validators;

public class fullNameValidator {
    public static boolean isValid(String fullName) {
        return fullName.length() <= 1311;
    }
}
