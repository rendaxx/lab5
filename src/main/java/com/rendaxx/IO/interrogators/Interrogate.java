package com.rendaxx.IO.interrogators;

import com.rendaxx.collection_object.Address;
import com.rendaxx.collection_object.Coordinates;
import com.rendaxx.collection_object.OrganizationType;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;

public interface Interrogate {
    String askName() throws IOException, WrongInputException;
    Coordinates askCoordinates() throws IOException, WrongInputException;
    long askAnnualTurnover() throws IOException, WrongInputException;
    String askFullName() throws IOException, WrongInputException;
    long askEmployeesCount() throws IOException, WrongInputException;
    OrganizationType askType() throws IOException, WrongInputException;
    Address askPostalAddress() throws IOException, WrongInputException;
}
