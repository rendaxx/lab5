package com.rendaxx.IO;

import com.rendaxx.CollectionServer;
import com.rendaxx.CommandManager;
import com.rendaxx.OrganizationManager;
import com.rendaxx.exceptions.BadScriptException;
import com.rendaxx.exceptions.UnknownCommandException;
import com.rendaxx.exceptions.WrongInputException;
import com.rendaxx.IO.interrogators.InterrogatorCLI;
import com.rendaxx.IO.interrogators.InterrogatorFile;
import com.rendaxx.utilities.ConsoleMode;
import com.rendaxx.utilities.LineCounter;

import java.io.*;
/**
 * Class for handling input from user or file.
 */
public class InputHandler {
    final LineCounter linesReadCount = new LineCounter();
    /**
     * Runs input processor.
     * @param is input stream.
     * @param cm console mode.
     * @throws BadScriptException if script has a problem.
     */
    public void runInputProcessor(InputStream is, ConsoleMode cm) throws BadScriptException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        CollectionServer collectionServer = OrganizationManager.getInstance();
        switch (cm) {
            case CLIMode -> collectionServer.setInterrogator(new InterrogatorCLI(in, linesReadCount));
            case FileMode -> collectionServer.setInterrogator(new InterrogatorFile(in, linesReadCount));
        }
        CommandManager commandManager = new CommandManager(collectionServer);
        while (true) {
            try {
                String line = in.readLine();
                if (line == null) {
                    switch (cm) {
                        case CLIMode -> throw new IOException(); // TODO
                        case FileMode -> throw new EOFException();
                    }
                }
                linesReadCount.increment();
                CommandInput input = new CommandInput(line);
                commandManager.execute(input);
            } catch (UnknownCommandException e) {
                switch (cm) {
                    case CLIMode -> System.err.println("Command " + e.getMessage() +
                            " does not exist. Type <help> for available commands.");
                    case FileMode -> throw new BadScriptException("Script has command that does not exist: " + e.getMessage());
                }

            } catch (WrongInputException e) {
                switch (cm) {
                    case CLIMode -> System.err.println(e.getMessage()); // TODO
                    case FileMode -> throw new BadScriptException("Script had a problem at line " + linesReadCount.getLinesCount() + ": " + e.getMessage());
                }
            } catch (EOFException e) {
                return;
            } catch (IOException e) {
                switch (cm) {
                    case CLIMode -> {
                        return;
                    }
                    case FileMode -> throw new BadScriptException();
                }
            }
        }
    }
}
