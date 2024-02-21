package com.rendaxx.utilities;

import com.rendaxx.collection_object.Organization;
import com.rendaxx.exceptions.WrongInputException;

import java.io.IOException;
/**
 * Interface for building organization object.
 */
public interface OrganizationBuilderInterface {
    OrganizationBuilderInterface setId();
    OrganizationBuilderInterface setName() throws IOException, WrongInputException;
    OrganizationBuilderInterface setCoordinates() throws IOException, WrongInputException;
    OrganizationBuilderInterface setCreationDate();
    OrganizationBuilderInterface setAnnualTurnover() throws IOException, WrongInputException;
    OrganizationBuilderInterface setFullName() throws IOException, WrongInputException;
    OrganizationBuilderInterface setEmployeesCount() throws IOException, WrongInputException;
    OrganizationBuilderInterface setType() throws IOException, WrongInputException;
    OrganizationBuilderInterface setPostalAddress() throws IOException, WrongInputException;
    Organization build();
}
