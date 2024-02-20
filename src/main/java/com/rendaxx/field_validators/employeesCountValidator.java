package com.rendaxx.field_validators;

public class employeesCountValidator {
    public static boolean notValid(long employeesCount) {
        return employeesCount < 0;
    }
}
