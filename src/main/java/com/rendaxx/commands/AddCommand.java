package com.rendaxx.commands;

import com.rendaxx.OrganizationServer;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class AddCommand extends Command {
    private static final String NAME = "add";
    private static final String ARGS = "{element}";
    private static final String DESC = "adds element in collection";

    OrganizationServer organizationServer;
    public AddCommand(OrganizationServer organizationServer) {
        super(NAME, ARGS, DESC);
        this.organizationServer = organizationServer;
    }

    @Override
    public void run(String[] args) throws IOException, WrongInputException {
        organizationServer.addElement();
    }
}
