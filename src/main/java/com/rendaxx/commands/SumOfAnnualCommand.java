package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
/**
 * Class for sum_of_annual_turnover command. This command prints sum of all annual_turnovers.
 * @see CollectionServer
 */
public class SumOfAnnualCommand extends Command {
    private static final String NAME = "sum_of_annual_turnover";
    private static final String ARGS = "";
    private static final String DESC = "prints sum of all annual_turnovers";

    final CollectionServer collectionServer;
    public SumOfAnnualCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }
    /**
     * Prints sum of all annual_turnovers.
     * @param args arguments for command
     */
    @Override
    public void run(String[] args) {
        collectionServer.sumOfAnnual();
    }
}
