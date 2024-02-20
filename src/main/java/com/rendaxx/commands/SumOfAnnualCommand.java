package com.rendaxx.commands;

import com.rendaxx.CollectionServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class SumOfAnnualCommand extends Command {
    private static final String NAME = "sum_of_annual_turnover";
    private static final String ARGS = "";
    private static final String DESC = "prints sum of all annual_turnovers";

    CollectionServer collectionServer;
    public SumOfAnnualCommand(CollectionServer collectionServer) {
        super(NAME, ARGS, DESC);
        this.collectionServer = collectionServer;
    }

    @Override
    public void run(String[] args) {
        collectionServer.sumOfAnnual();
    }
}
