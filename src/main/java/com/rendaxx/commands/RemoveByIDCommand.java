package com.rendaxx.commands;

import com.rendaxx.OrganizationServer;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class RemoveByIDCommand extends Command {
    private static final String NAME = "remove_by_id";
    private static final String ARGS = "id";
    private static final String DESC = "removes element by his id";

    OrganizationServer organizationServer;
    public RemoveByIDCommand(OrganizationServer organizationServer) {
        super(NAME, ARGS, DESC);
        this.organizationServer = organizationServer;
    }

    @Override
    public void run(String[] args) throws IOException, InvalidArgumentCountException, WrongInputException {
        if (args.length != 1) {
            throw new InvalidArgumentCountException();
        }
        Long id = null;
        try {
            id = Long.parseLong(args[0]);
        } catch (NumberFormatException e) {
            throw new WrongInputException();
        }
        organizationServer.removeElementById(id);
    }
}
