package com.rendaxx.commands;

import com.rendaxx.OrganizationServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class ShowCommand extends Command {
    private static final String NAME = "show";
    private static final String ARGS = "";
    private static final String DESC = "prints collection's elements";

    OrganizationServer organizationServer;
    public ShowCommand(OrganizationServer organizationServer) {
        super(NAME, ARGS, DESC);
        this.organizationServer = organizationServer;
    }
    @Override
    public void run(String[] args) throws IOException, InvalidArgumentCountException, WrongInputException {
        organizationServer.collectionShow();
    }
}
