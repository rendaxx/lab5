package com.rendaxx.interrogators;

import com.rendaxx.collection_object.Address;
import com.rendaxx.collection_object.Coordinates;
import com.rendaxx.collection_object.OrganizationType;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public interface Interrogate {
    public String askName() throws IOException, WrongInputException;
    public Coordinates askCoordinates() throws IOException, WrongInputException;
    public long askAnnualTurnover() throws IOException, WrongInputException;
    public String askFullName() throws IOException, WrongInputException;
    public long askEmployeesCount() throws IOException, WrongInputException;
    public OrganizationType askType() throws IOException, WrongInputException;
    public Address askPostalAddress() throws IOException, WrongInputException;
}
