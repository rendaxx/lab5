package com.rendaxx.field_validators;

public class fullNameValidator {
    public static boolean notValid(String fullName) {
        return fullName.length() > 1311;
    }
}
