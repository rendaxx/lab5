package com.rendaxx.exceptions;

public class UnknownCommandException extends Exception {
    public UnknownCommandException() {
        super("<command name not provided>");
    }

    public UnknownCommandException(String commandName) {
        super("<" + commandName + ">");
    }
}
