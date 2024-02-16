package com.rendaxx.interrogators;

import com.rendaxx.collection_object.Address;
import com.rendaxx.collection_object.Coordinates;
import com.rendaxx.collection_object.OrganizationType;

import java.util.Scanner;

public class InterrogatorFile implements Interrogate {

    Scanner in;
    public InterrogatorFile(Scanner sc) {
        in = sc;
    }
    @Override
    public String askName() {
        return null;
    }

    @Override
    public Coordinates askCoordinates() {
        return null;
    }

    @Override
    public long askAnnualTurnover() {
        return 0;
    }

    @Override
    public String askFullName() {
        return null;
    }

    @Override
    public long askEmployeesCount() {
        return 0;
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
