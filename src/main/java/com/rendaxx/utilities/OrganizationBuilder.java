package com.rendaxx.utilities;

import com.rendaxx.collectionobject.Organization;
import com.rendaxx.exceptions.WrongInputException;
import com.rendaxx.IO.interrogators.Interrogator;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
/**
 * Class for building organization object.
 */
public class OrganizationBuilder implements OrganizationBuilderInterface {
    private final Organization org;
    public OrganizationBuilder(Organization org) {
        this.org = org;
    }
    Interrogator interrogator;

    public OrganizationBuilder(Interrogator i) {
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
        var x = interrogator.askName();
        if (x == null) throw new WrongInputException();
        org.setName(x);
        return this;
    }

    @Override
    public OrganizationBuilderInterface setCoordinates() throws IOException, WrongInputException {
        var x = interrogator.askCoordinates();
        if (x == null) throw new WrongInputException();
        org.setCoordinates(x);
        return this;
    }

    @Override
    public OrganizationBuilderInterface setCreationDate() {
        org.setCreationDate(new Date());
        return this;
    }

    @Override
    public OrganizationBuilderInterface setAnnualTurnover() throws IOException, WrongInputException {
        var x = interrogator.askAnnualTurnover();
        if (x == null) throw new WrongInputException();
        org.setAnnualTurnover(x);
        return this;
    }

    @Override
    public OrganizationBuilderInterface setFullName() throws IOException, WrongInputException {
        var x = interrogator.askFullName();
        if (x == null) throw new WrongInputException();
        org.setFullName(x);
        return this;
    }

    @Override
    public OrganizationBuilderInterface setEmployeesCount() throws IOException, WrongInputException {
        var x = interrogator.askEmployeesCount();
        if (x == null) throw new WrongInputException();
        org.setEmployeesCount(x);
        return this;
    }

    @Override
    public OrganizationBuilderInterface setType() throws IOException, WrongInputException {
        var x = interrogator.askType();
        if (x == null) throw new WrongInputException();
        org.setType(x);
        return this;
    }

    @Override
    public OrganizationBuilderInterface setPostalAddress() throws IOException, WrongInputException {
        var x = interrogator.askPostalAddress();
        if (x == null) throw new WrongInputException();
        org.setPostalAddress(x);
        return this;
    }

    @Override
    public Organization build() {
        return org;
    }
}
