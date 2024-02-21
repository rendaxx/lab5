package com.rendaxx.field_validators;
/**
 * Validator for annualTurnover field.
 * @see annualTurnoverValidator
 */
public class annualTurnoverValidator {
    public static boolean notValid(long annualTurnover) {
        return annualTurnover < 0;
    }
}
