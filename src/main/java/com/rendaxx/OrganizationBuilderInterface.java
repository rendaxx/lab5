package com.rendaxx;

import com.rendaxx.collection_object.Organization;

import java.io.EOFException;

public interface OrganizationBuilderInterface {
    OrganizationBuilderInterface setId();
    OrganizationBuilderInterface setName() throws EOFException;
    OrganizationBuilderInterface setCoordinates() throws EOFException;
    OrganizationBuilderInterface setCreationDate();
    OrganizationBuilderInterface setAnnualTurnover() throws EOFException;
    OrganizationBuilderInterface setFullName() throws EOFException;
    OrganizationBuilderInterface setEmployeesCount() throws EOFException;
    OrganizationBuilderInterface setType() throws EOFException;
    OrganizationBuilderInterface setPostalAddress() throws EOFException;
    Organization build();
}
