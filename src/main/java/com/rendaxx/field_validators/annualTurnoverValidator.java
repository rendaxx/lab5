package com.rendaxx.field_validators;

public class annualTurnoverValidator {
    public static boolean notValid(long annualTurnover) {
        return annualTurnover < 0;
    }
}
