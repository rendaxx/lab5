package com.rendaxx.fieldvalidators;
/**
 * Validator for coordinates field.
 * @see com.rendaxx.collectionobject.Coordinates
 */
public class coordinatesValidator {
    public static boolean notValidX(Double x) {
        return x == null;
    }

    public static boolean notValidY(Double y) {
        return y == null || y <= -162;
    }
}
