package com.rendaxx.utilities;

import com.rendaxx.collection_object.Organization;
import com.rendaxx.exceptions.WrongInputException;
import com.rendaxx.IO.interrogators.Interrogate;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class OrganizationBuilder implements OrganizationBuilderInterface {
    private Organization org;
    public OrganizationBuilder(Organization org) {
        this.org = org;
    }
    Interrogate interrogator;

    public OrganizationBuilder(Interrogate i) {
        this.interrogator = i;
        this.org = new Organization();
    }

    @Override
    public OrganizationBuilderInterface setId() {
        org.setId(new Random().nextLong(Long.MAX_VALUE));
        return this;
    }

    @Override
    public OrganizationBuilderInterface setName() throws IOException, WrongInputException {
        org.setName(interrogator.askName());
        return this;
    }

    @Override
    public OrganizationBuilderInterface setCoordinates() throws IOException, WrongInputException {
        org.setCoordinates(interrogator.askCoordinates());
        return this;
    }

    @Override
    public OrganizationBuilderInterface setCreationDate() {
        org.setCreationDate(new Date());
        return this;
    }

    @Override
    public OrganizationBuilderInterface setAnnualTurnover() throws IOException, WrongInputException {
        org.setAnnualTurnover(interrogator.askAnnualTurnover());
        return this;
    }

    @Override
    public OrganizationBuilderInterface setFullName() throws IOException, WrongInputException {
        org.setFullName(interrogator.askFullName());
        return this;
    }

    @Override
    public OrganizationBuilderInterface setEmployeesCount() throws IOException, WrongInputException {
        org.setEmployeesCount(interrogator.askEmployeesCount());
        return this;
    }

    @Override
    public OrganizationBuilderInterface setType() throws IOException, WrongInputException {
        org.setType(interrogator.askType());
        return this;
    }

    @Override
    public OrganizationBuilderInterface setPostalAddress() throws IOException, WrongInputException {
        org.setPostalAddress(interrogator.askPostalAddress());
        return this;
    }

    @Override
    public Organization build() {
        return org;
    }
}
