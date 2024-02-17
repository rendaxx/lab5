package com.rendaxx.commands;

import com.rendaxx.OrganizationBuilder;
import com.rendaxx.OrganizationServer;
import com.rendaxx.collection_object.Organization;
import com.rendaxx.exceptions.InvalidArgumentCountException;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public class UpdateCommand extends Command{
    private static final String NAME = "update";
    private static final String ARGS = "id {element}";
    private static final String DESC = "updates element by his id";

    OrganizationServer organizationServer;
    public UpdateCommand(OrganizationServer organizationServer) {
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
        organizationServer.updateElement(id);
    }
}
