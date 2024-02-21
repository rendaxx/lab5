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
        CollectionServer collectionServer = OrganizationManager.getInstance();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(is))) {
            switch (cm) {
                case CLIMode -> collectionServer.setInterrogator(new InterrogatorCLI(in, linesReadCount));
                case FileMode -> collectionServer.setInterrogator(new InterrogatorFile(in, linesReadCount));
            }
            CommandManager commandManager = new CommandManager(collectionServer);
            String line;
            while ((line = in.readLine()) != null) {
                linesReadCount.increment();
                CommandInput input = new CommandInput(line);
                commandManager.execute(input);
            }
        } catch (IOException e) {
            return;
        }
    }
}
