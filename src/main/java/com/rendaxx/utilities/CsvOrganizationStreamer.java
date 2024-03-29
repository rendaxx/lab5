package com.rendaxx.utilities;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.rendaxx.IO.CollectionStreamer;
import com.rendaxx.collectionobject.Organization;
import com.rendaxx.exceptions.NoFileException;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
/**
 * Class for saving and reading collection of organizations to/from csv file.
 */
public class CsvOrganizationStreamer implements CollectionStreamer<LinkedHashSet<Organization>> {

    private static CsvOrganizationStreamer singleton;
    private Path pathToFile;

    public static CsvOrganizationStreamer getInstance() {
        if (singleton == null)
            singleton = new CsvOrganizationStreamer();
        return singleton;
    }

    private CsvOrganizationStreamer() {}

    public void setPathToFile(Path p) {
        this.pathToFile = p;
    }

    @Override
    public void saveToFile(LinkedHashSet<Organization> collection) throws NoFileException {
        if (pathToFile == null || Files.notExists(pathToFile)) {
            throw new NoFileException();
        }
        try (Writer writer = new PrintWriter(pathToFile.toFile())) {
            StatefulBeanToCsv<Organization> beanToCsv = new StatefulBeanToCsvBuilder<Organization>(writer)
                    .withSeparator(',')
                    .build();

            beanToCsv.write(collection.stream());
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public LinkedHashSet<Organization> readFromFile() throws NoFileException {
        if (pathToFile == null || Files.notExists(pathToFile)) {
            throw new NoFileException();
        }
        try {
            return new CsvToBeanBuilder<>(Files.newBufferedReader(pathToFile))
                    .withType(Organization.class)
                    .build().parse().stream().map(q -> (Organization) q).collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (IOException e) {
            return new LinkedHashSet<>();
        }
    }
}
