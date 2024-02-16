package com.rendaxx.validators;

public class coordinatesValidator {
    public static boolean isValidX(Double x) {
        return x != null;
    }

    public static boolean isValidY(Double y) {
        return y != null && y > -162;
    }
}
