package com.rendaxx.field_validators;

public class nameValidator {
    public static boolean notValid(String name) {
        return name == null || name.isEmpty();
    }
}
