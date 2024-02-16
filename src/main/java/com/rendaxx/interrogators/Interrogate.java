package com.rendaxx.interrogators;

import com.rendaxx.collection_object.Address;
import com.rendaxx.collection_object.Coordinates;
import com.rendaxx.collection_object.OrganizationType;

import java.io.EOFException;

public interface Interrogate {
    public String askName() throws EOFException;
    public Coordinates askCoordinates() throws EOFException;
    public long askAnnualTurnover() throws EOFException;
    public String askFullName() throws EOFException;
    public long askEmployeesCount() throws EOFException;
    public OrganizationType askType() throws EOFException;
    public Address askPostalAddress() throws EOFException;
}
