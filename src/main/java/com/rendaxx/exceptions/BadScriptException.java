package com.rendaxx.exceptions;
/**
 * Exception thrown when something wrong in script.
 */
public class BadScriptException extends Exception {
    public BadScriptException() {
        super("Something wrong in this script.");
    }

    public BadScriptException(String message) {
        super(message);
    }
}
