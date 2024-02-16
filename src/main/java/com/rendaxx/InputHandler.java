package com.rendaxx;

import com.rendaxx.exceptions.UnknownCommandException;
import com.rendaxx.interrogators.InterrogatorCLI;
import com.rendaxx.interrogators.InterrogatorFile;

import java.io.InputStream;
import java.util.Scanner;

public class InputHandler {

    public void runInputProcessor(InputStream is, ConsoleMode cm) {
        Scanner in = new Scanner(is);
        OrganizationServer organizationServer = null;
        switch (cm) {
            case CLIMode -> organizationServer = new OrganizationManager(new InterrogatorCLI(in));
            case FileMode -> organizationServer = new OrganizationManager(new InterrogatorFile(in));
        }
        CommandManager commandManager = new CommandManager(in, organizationServer);
        while (in.hasNext()) {
            try {
                String line = in.nextLine();
                CommandInput input = new CommandInput(line);
                commandManager.execute(input);
            } catch (UnknownCommandException e) {
                System.err.println("Command " + e.getMessage() + " does not exist. Type <help> for available commands.");
            }
        }
    }
}
