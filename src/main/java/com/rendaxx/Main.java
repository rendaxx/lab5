package com.rendaxx;

import com.rendaxx.exceptions.BadScriptException;
import com.rendaxx.exceptions.NoFileException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        OrganizationManager organizationManager = OrganizationManager.getInstance();
        CsvOrganizationStreamer csvOrganizationStreamer = new CsvOrganizationStreamer();
        organizationManager.setCollectionStreamer(csvOrganizationStreamer);
        Path path = Path.of(args[0]);
        csvOrganizationStreamer.setPathToFile(path);
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