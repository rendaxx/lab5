package com.rendaxx;

public class Main {
    public static void main(String[] args) {
        // OrganizationManager organizationManager = new OrganizationManager();
        // AddCommand addCommand = new AddCommand(organizationManager);
        new InputHandler().runInputProcessor(System.in, ConsoleMode.CLIMode);
    }
}