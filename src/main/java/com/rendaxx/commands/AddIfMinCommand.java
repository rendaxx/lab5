package com.rendaxx.commands;

import com.rendaxx.OrganizationServer;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class AddIfMinCommand extends Command {
    private static final String NAME = "add_if_min";
    private static final String ARGS = "{element}";
    private static final String DESC = "adds {element} in collection if its value is lower than collection's minimum";

    OrganizationServer organizationServer;
    public AddIfMinCommand(OrganizationServer organizationServer) {
        super(NAME, ARGS, DESC);
        this.organizationServer = organizationServer;
    }

    @Override
    public void run(String[] args) throws IOException, WrongInputException {
        organizationServer.addIfMin();
    }
}
