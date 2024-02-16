package com.rendaxx.interrogators;

import com.rendaxx.collection_object.Address;
import com.rendaxx.collection_object.Coordinates;
import com.rendaxx.collection_object.OrganizationType;

import java.util.Scanner;

public class InterrogatorCLI implements Interrogate {
    Scanner in;
    public InterrogatorCLI(Scanner sc) {
        in = sc;
    }
    @Override
    public String askName() {
        String name = in.nextLine();
        return name;
    }

    @Override
    public Coordinates askCoordinates() {
        return null;
    }

    @Override
    public Integer askAnnualTurnover() {
        return null;
    }

    @Override
    public String askFullName() {
        return null;
    }

    @Override
    public Long askEmployeesCount() {
        return null;
    }

    @Override
    public OrganizationType askType() {
        return null;
    }

    @Override
    public Address askPostalAddress() {
        return null;
    }
}
