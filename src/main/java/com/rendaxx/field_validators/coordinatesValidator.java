package com.rendaxx.field_validators;
/**
 * Validator for coordinates field.
 * @see com.rendaxx.collection_object.Coordinates
 */
public class coordinatesValidator {
    public static boolean notValidX(Double x) {
        return x == null;
    }

    public static boolean notValidY(Double y) {
        return y == null || y <= -162;
    }
}
