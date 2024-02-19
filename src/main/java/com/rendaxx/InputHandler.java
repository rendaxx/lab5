package com.rendaxx;

import com.rendaxx.exceptions.BadScriptException;
import com.rendaxx.exceptions.UnknownCommandException;
import com.rendaxx.exceptions.WrongInputException;
import com.rendaxx.interrogators.InterrogatorCLI;
import com.rendaxx.interrogators.InterrogatorFile;

import java.io.*;

public class InputHandler {
    LineCounter linesReadCount = new LineCounter();
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
