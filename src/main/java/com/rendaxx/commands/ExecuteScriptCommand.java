package com.rendaxx.commands;

import com.rendaxx.utilities.ConsoleMode;
import com.rendaxx.IO.InputHandler;
import com.rendaxx.utilities.ScriptValidator;
import com.rendaxx.exceptions.BadScriptException;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.*;
import java.nio.file.Path;

/**
 * Class for execute_script command. This command reads and executes script from file.
 */
public class ExecuteScriptCommand extends Command {
    private static final String NAME = "execute_script";
    private static final String ARGS = "file_name";
    private static final String DESC = "reads and executes script from file";
    public ExecuteScriptCommand() {
        super(NAME, ARGS, DESC);
    }
    /**
     * Method for executing execute_script command.
     * @param args command arguments
     * @throws IOException if an I/O error occurs
     * @throws InvalidArgumentCountException if there is invalid number of arguments
     * @throws WrongInputException if there is an error in input
     */
    @Override
    public void run(String[] args) throws IOException, WrongInputException {
        if (args.length != 1) {
            throw new WrongInputException("Wrong amount of args");
        }
        Path path = Path.of(args[0]);
        try {
            ScriptValidator scriptValidator = new ScriptValidator();
            if (!scriptValidator.validate(path)) {
                throw new BadScriptException();
            }
        } catch (BadScriptException e) {
            throw new WrongInputException(e.getMessage());
        }

        try (InputStream fileInputStream = new FileInputStream(path.toFile())) {
            new InputHandler().runInputProcessor(fileInputStream, ConsoleMode.FileMode);
        } catch (FileNotFoundException | BadScriptException e) {
            throw new WrongInputException(e.getMessage());
        }
    }
}
