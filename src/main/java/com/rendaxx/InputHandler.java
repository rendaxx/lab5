package com.rendaxx;

import com.rendaxx.exceptions.BadScriptException;
import com.rendaxx.exceptions.UnknownCommandException;
import com.rendaxx.exceptions.WrongInputException;
import com.rendaxx.interrogators.InterrogatorCLI;
import com.rendaxx.interrogators.InterrogatorFile;

import java.io.*;

public class InputHandler {

    public void runInputProcessor(InputStream is, ConsoleMode cm) throws BadScriptException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        OrganizationServer organizationServer = null;
        switch (cm) {
            case CLIMode -> organizationServer = new OrganizationManager(new InterrogatorCLI(in));
            case FileMode -> organizationServer = new OrganizationManager(new InterrogatorFile(in));
        }
        CommandManager commandManager = new CommandManager(organizationServer);
        while (true) {
            try {
                String line = in.readLine();
                if (line == null) {
                    switch (cm) {
                        case CLIMode -> throw new IOException(); // TODO
                        case FileMode -> throw new EOFException();
                    }
                }
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
                    case FileMode -> throw new BadScriptException("Script had a problem: " + e.getMessage());
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
