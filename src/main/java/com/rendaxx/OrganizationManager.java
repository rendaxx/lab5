package com.rendaxx;

import com.rendaxx.collection_object.Organization;
import com.rendaxx.exceptions.WrongInputException;
import com.rendaxx.interrogators.Interrogate;

import java.io.EOFException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;

public class OrganizationManager implements OrganizationServer {
    private LinkedHashSet<Organization> organizations;
    private Interrogate interrogator;
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;

    public OrganizationManager(Interrogate i) {
        this.interrogator = i;
        organizations = new LinkedHashSet<>();
    }

    @Override
    public void addElement() throws IOException, WrongInputException {
        Organization org = new OrganizationBuilder(interrogator)
                .setId()
                .setName()
                .setCoordinates()
                .setCreationDate()
                .setAnnualTurnover()
                .setFullName()
                .setEmployeesCount()
                .setType()
                .setPostalAddress()
                .build();
        organizations.add(org);
    }

    @Override
    public void collectionInfo() {
        System.out.println("type: " + organizations.getClass().getSimpleName());
        System.out.println("init time: " + lastInitTime);
        System.out.println("last save time: " + lastSaveTime);
        System.out.println("number of elements: " + organizations.size());
    }

    @Override
    public void collectionShow() {
        organizations.forEach(System.out::println);
    }

    @Override
    public void updateElement(Long id) throws WrongInputException, IOException {
        var answer = organizations.stream().filter(organization ->
                Objects.equals(organization.getId(), id)).findFirst();
        if (answer.isEmpty()) {
            throw new WrongInputException();
        }
        new OrganizationBuilder(answer.get())
                .setName()
                .setCoordinates()
                .setCreationDate()
                .setAnnualTurnover()
                .setFullName()
                .setEmployeesCount()
                .setType()
                .setPostalAddress();
    }

    @Override
    public void removeElementById(Long id) throws WrongInputException {
        var answer = organizations.stream().filter(organization ->
                Objects.equals(organization.getId(), id)).findFirst();
        if (answer.isEmpty()) {
            throw new WrongInputException();
        }
        organizations.remove(answer.get());
    }

    @Override
    public void clearCollection() {
        organizations.clear();
    }

    @Override
    public void addIfMin() throws IOException, WrongInputException {
        Organization org = new OrganizationBuilder(interrogator)
                .setId()
                .setName()
                .setCoordinates()
                .setCreationDate()
                .setAnnualTurnover()
                .setFullName()
                .setEmployeesCount()
                .setType()
                .setPostalAddress()
                .build();
        var answer = organizations.stream().min(Organization::compareTo);
        if (answer.isEmpty() || org.compareTo(answer.get()) < 0) {
            organizations.add(org);
        }
    }


}
