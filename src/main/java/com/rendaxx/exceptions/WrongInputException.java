package com.rendaxx.exceptions;
/**
 * Exception thrown when input is wrong.
 */
public class WrongInputException extends Exception {
    public WrongInputException() {
        super("You've entered something wrong. Please try again");
    }

    public WrongInputException(String message) {
        super(message);
    }
}
