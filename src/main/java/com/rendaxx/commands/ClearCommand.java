package com.rendaxx.commands;

import com.rendaxx.OrganizationServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class ClearCommand extends Command {
    private static final String NAME = "clear";
    private static final String ARGS = "";
    private static final String DESC = "clears collection";

    OrganizationServer organizationServer;
    public ClearCommand(OrganizationServer organizationServer) {
        super(NAME, ARGS, DESC);
        this.organizationServer = organizationServer;
    }

    @Override
    public void run(String[] args) throws IOException, InvalidArgumentCountException, WrongInputException {
        organizationServer.clearCollection();
    }
}
