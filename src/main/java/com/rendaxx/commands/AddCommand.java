package com.rendaxx.commands;

import com.rendaxx.*;
import com.rendaxx.collection_object.Organization;
import com.rendaxx.interrogators.Interrogate;
import com.rendaxx.interrogators.InterrogatorCLI;
import com.rendaxx.interrogators.InterrogatorFile;

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
    public void run(String[] args) {
        organizationServer.addElement();
    }
}
