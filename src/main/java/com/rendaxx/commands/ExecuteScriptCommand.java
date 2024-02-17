package com.rendaxx.commands;

import com.rendaxx.CommandManager;
import com.rendaxx.ConsoleMode;
import com.rendaxx.InputHandler;
import com.rendaxx.exceptions.BadScriptException;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class ExecuteScriptCommand extends Command {
    private static final String NAME = "execute_script";
    private static final String ARGS = "file_name";
    private static final String DESC = "reads and executes script from file";
    public ExecuteScriptCommand() {
        super(NAME, ARGS, DESC);
    }

    @Override
    public void run(String[] args) throws IOException, InvalidArgumentCountException, WrongInputException {
        if (args.length != 1) {
            throw new InvalidArgumentCountException();
        }
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {
            new InputHandler().runInputProcessor(fileInputStream, ConsoleMode.FileMode);
        } catch (FileNotFoundException e) {
            throw new WrongInputException();
        } catch (BadScriptException e) {
            throw new WrongInputException(e.getMessage());
        }
    }
}
