package com.rendaxx;

import com.rendaxx.collection_object.Organization;
import com.rendaxx.exceptions.NoFileException;
import com.rendaxx.exceptions.WrongInputException;
import com.rendaxx.interrogators.Interrogate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;

public class OrganizationManager implements CollectionServer {
    private static OrganizationManager singleton;
    private LinkedHashSet<Organization> organizations;
    private Interrogate interrogator;
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;

    private CollectionStreamer<LinkedHashSet<Organization>> collectionStreamer;

    public static OrganizationManager getInstance() {
        if (singleton == null)
            singleton = new OrganizationManager();
        return singleton;
    }

    private OrganizationManager() {
        organizations = new LinkedHashSet<>();
        lastInitTime = LocalDateTime.now();
    }

    @Override
    public void setInterrogator(Interrogate interrogator) {
        this.interrogator = interrogator;
    }

    @Override
    public void deleteInvalidElements() {
        organizations.stream().filter(o -> !o.validate()).forEach(organizations::remove);
    }

    public void setOrganizations(LinkedHashSet<Organization> organizations) {
        this.organizations = organizations;
    }

    public void setCollectionStreamer(CollectionStreamer<LinkedHashSet<Organization>> collectionStreamer) {
        this.collectionStreamer = collectionStreamer;
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

    @Override
    public void removeGreater() throws IOException, WrongInputException {
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
        organizations.stream().filter(o -> o.compareTo(org) > 0).forEach(organizations::remove);
    }

    @Override
    public void removeLower() throws IOException, WrongInputException {
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
        organizations.stream().filter(o -> o.compareTo(org) < 0).forEach(organizations::remove);
    }

    @Override
    public void sumOfAnnual() {
        Long result = organizations.stream().map(Organization::getAnnualTurnover).reduce(0L, Long::sum);
        System.out.println("Sum of annualTurnover is: " + result);
    }

    @Override
    public void filterStartsWithName(String name) {
        organizations.stream().filter(o -> o.getName().startsWith(name)).forEach(System.out::println);
    }

    @Override
    public void printsAscending() {
        organizations.stream().map(Organization::getFullName).sorted().forEach(System.out::println);
    }

    @Override
    public void save() throws NoFileException {
        if (collectionStreamer == null) {
            throw new RuntimeException("No collection streamer == no saving >:(");
        }
        collectionStreamer.saveToFile(organizations);
    }

    @Override
    public void load() throws NoFileException {
        if (collectionStreamer == null) {
            throw new RuntimeException("No collection streamer == no loading >:(");
        }
        organizations = collectionStreamer.readFromFile();
        deleteInvalidElements();
    }

}
