package com.rendaxx.field_validators;
/**
 * Validator for employeesCount field.
 */
public class employeesCountValidator {
    public static boolean notValid(long employeesCount) {
        return employeesCount < 0;
    }
}
