package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
/**
 * Class for print_field_ascending_full_name command. This command prints all fullNames sorted.
 * @see CollectionServer
 */
public class PrintAscendingFullCommand extends Command {
    private static final String NAME = "print_field_ascending_full_name";
    private static final String ARGS = "";
    private static final String DESC = "prints all fullNames sorted";

    final CollectionServer collectionServer;
    public PrintAscendingFullCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    /**
     * Prints all fullNames sorted.
     * @param args arguments for command
     */
    @Override
    public void run(String[] args) {
        collectionServer.printsAscending();
    }
}
