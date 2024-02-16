package com.rendaxx;

import com.rendaxx.collection_object.Organization;
import com.rendaxx.interrogators.Interrogate;

import java.io.EOFException;
import java.util.LinkedHashSet;

public class OrganizationManager implements OrganizationServer {
    LinkedHashSet<Organization> organizations;
    Interrogate interrogator;

    public OrganizationManager(Interrogate i) {
        this.interrogator = i;
    }

    @Override
    public void addElement() throws EOFException {
        Organization org = new OrganizationBuilder(interrogator)
                .setId()
                .setName()
                .setCoordinates()
                .setCreationDate()
                .setAnnualTurnover()
                .setFullName()
                .setEmployeesCount()
                .setType()
                .setPostalAddress()
                .build();
        organizations.add(org);
    }
}
