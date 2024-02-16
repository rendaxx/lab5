package com.rendaxx;

import com.rendaxx.collection_object.Address;
import com.rendaxx.collection_object.Coordinates;
import com.rendaxx.collection_object.Organization;
import com.rendaxx.collection_object.OrganizationType;
import com.rendaxx.interrogators.Interrogate;

import java.io.EOFException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class OrganizationBuilder implements OrganizationBuilderInterface {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long annualTurnover; //Значение поля должно быть больше 0
    private String fullName; //Длина строки не должна быть больше 1311, Поле может быть null
    private long employeesCount; //Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null
    private Address postalAddress; //Поле не может быть null

    Interrogate interrogator;

    public OrganizationBuilder(Interrogate i) {
        this.interrogator = i;
    }

    @Override
    public OrganizationBuilderInterface setId() {
        this.id = new Random().nextLong(Long.MAX_VALUE);
        return this;
    }

    @Override
    public OrganizationBuilderInterface setName() throws EOFException {
        this.name = interrogator.askName();
        return this;
    }

    @Override
    public OrganizationBuilderInterface setCoordinates() throws EOFException {
        this.coordinates = interrogator.askCoordinates();
        return this;
    }

    @Override
    public OrganizationBuilderInterface setCreationDate() {
        this.creationDate = new Date();
        return this;
    }

    @Override
    public OrganizationBuilderInterface setAnnualTurnover() throws EOFException {
        this.annualTurnover = interrogator.askAnnualTurnover();
        return this;
    }

    @Override
    public OrganizationBuilderInterface setFullName() throws EOFException {
        this.fullName = interrogator.askFullName();
        return this;
    }

    @Override
    public OrganizationBuilderInterface setEmployeesCount() throws EOFException {
        this.employeesCount = interrogator.askEmployeesCount();
        return this;
    }

    @Override
    public OrganizationBuilderInterface setType() throws EOFException {
        this.type = interrogator.askType();
        return this;
    }

    @Override
    public OrganizationBuilderInterface setPostalAddress() throws EOFException {
        this.postalAddress = interrogator.askPostalAddress();
        return this;
    }

    @Override
    public Organization build() {
        return new Organization(id, name, coordinates, creationDate, annualTurnover, fullName, employeesCount,
                type, postalAddress);
    }
}
