package com.rendaxx.exceptions;
/**
 * Exception thrown when command name is unknown.
 */
public class UnknownCommandException extends Exception {
    public UnknownCommandException() {
        super("<command name not provided>");
    }

    public UnknownCommandException(String commandName) {
        super("<" + commandName + ">");
    }
}
