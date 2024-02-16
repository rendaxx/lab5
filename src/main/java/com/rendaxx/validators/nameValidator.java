package com.rendaxx.validators;

public class nameValidator {
    public static boolean isValid(String name) {
        return name != null && !name.isEmpty();
    }
}
