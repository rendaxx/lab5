package com.rendaxx.validators;

public class fullNameValidator {
    boolean validate(String name) {
        return name != null && !name.isEmpty();
    }
}
