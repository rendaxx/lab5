package com.rendaxx.exceptions;

public class WrongInputException extends Exception {
    public WrongInputException() {
        super("You've entered something wrong. Please try again");
    }

    public WrongInputException(String message) {
        super(message);
    }
}
