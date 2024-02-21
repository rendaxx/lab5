package com.rendaxx.IO.interrogators;

import com.rendaxx.collectionobject.Address;
import com.rendaxx.collectionobject.Coordinates;
import com.rendaxx.collectionobject.OrganizationType;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;
/**
 * Interface for asking user input.
 */
public interface Interrogator {
    String askName() throws IOException, WrongInputException;
    Coordinates askCoordinates() throws IOException, WrongInputException;
    Long askAnnualTurnover() throws IOException, WrongInputException;
    String askFullName() throws IOException, WrongInputException;
    Long askEmployeesCount() throws IOException, WrongInputException;
    OrganizationType askType() throws IOException, WrongInputException;
    Address askPostalAddress() throws IOException, WrongInputException;
}
