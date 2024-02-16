package com.rendaxx;

import com.rendaxx.collection_object.Organization;

public interface OrganizationBuilderInterface {
    OrganizationBuilderInterface setId();
    OrganizationBuilderInterface setName();
    OrganizationBuilderInterface setCoordinates();
    OrganizationBuilderInterface setCreationDate();
    OrganizationBuilderInterface setAnnualTurnover();
    OrganizationBuilderInterface setFullName();
    OrganizationBuilderInterface setEmployeesCount();
    OrganizationBuilderInterface setType();
    OrganizationBuilderInterface setPostalAddress();
    Organization build();
}
