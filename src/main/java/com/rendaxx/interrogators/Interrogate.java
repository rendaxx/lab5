package com.rendaxx.interrogators;

import com.rendaxx.collection_object.Address;
import com.rendaxx.collection_object.Coordinates;
import com.rendaxx.collection_object.OrganizationType;

public interface Interrogate {
    public String askName();
    public Coordinates askCoordinates();
    public Integer askAnnualTurnover();
    public String askFullName();
    public Long askEmployeesCount();
    public OrganizationType askType();
    public Address askPostalAddress();
}
