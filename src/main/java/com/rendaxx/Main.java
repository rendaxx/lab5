package com.rendaxx;

import com.rendaxx.IO.InputHandler;
import com.rendaxx.exceptions.BadScriptException;
import com.rendaxx.exceptions.NoFileException;
import com.rendaxx.utilities.ConsoleMode;
import com.rendaxx.utilities.CsvOrganizationStreamer;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        OrganizationManager organizationManager = OrganizationManager.getInstance();
        CsvOrganizationStreamer csvOrganizationStreamer = CsvOrganizationStreamer.getInstance();
        organizationManager.setCollectionStreamer(csvOrganizationStreamer);
        Path path;
        if (args.length > 0) {
            path = Path.of(args[0]);
            csvOrganizationStreamer.setPathToFile(path);
        }
        try {
            organizationManager.load();
        } catch (NoFileException e) {
            System.err.println("Wrong file provided. You can't use <save>");
        }
        try {
            new InputHandler().runInputProcessor(System.in, ConsoleMode.CLIMode);
        } catch (BadScriptException ignore) {

        }
    }
}