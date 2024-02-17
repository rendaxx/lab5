package com.rendaxx.commands;

import com.rendaxx.OrganizationServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class InfoCommand extends Command {
    private static final String NAME = "info";
    private static final String ARGS = "";
    private static final String DESC = "prints collection's info";

    OrganizationServer organizationServer;
    public InfoCommand(OrganizationServer organizationServer) {
        super(NAME, ARGS, DESC);
        this.organizationServer = organizationServer;
    }
    @Override
    public void run(String[] args) throws IOException, InvalidArgumentCountException, WrongInputException {
        organizationServer.collectionInfo();
    }
}
