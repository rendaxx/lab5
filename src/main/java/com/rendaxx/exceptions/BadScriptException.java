package com.rendaxx.exceptions;

public class BadScriptException extends Exception {
    public BadScriptException() {
        super("Something wrong in this script.");
    }

    public BadScriptException(String message) {
        super(message);
    }
}
