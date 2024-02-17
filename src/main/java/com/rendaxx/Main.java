package com.rendaxx;

import com.rendaxx.exceptions.BadScriptException;

public class Main {
    public static void main(String[] args) {
        try {
            new InputHandler().runInputProcessor(System.in, ConsoleMode.CLIMode);
        } catch (BadScriptException ignore) {

        }
    }
}