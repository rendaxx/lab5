package com.rendaxx.IO.interrogators;

import com.rendaxx.utilities.LineCounter;
import com.rendaxx.collectionobject.Address;
import com.rendaxx.collectionobject.Coordinates;
import com.rendaxx.collectionobject.OrganizationType;
import com.rendaxx.exceptions.WrongInputException;
import com.rendaxx.fieldvalidators.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.InputMismatchException;
/**
 * Class for asking user input from file.
 */
public class InterrogatorFile implements Interrogator {
    final LineNumberReader in;
    final LineCounter linesReadCount;
    public InterrogatorFile(BufferedReader br, LineCounter lrc) {
        in = new LineNumberReader(br);
        linesReadCount = lrc;
    }
    /**
     * Reads line from BufferedReader.
     * @return line from BufferedReader.
     */
    private String readLine() throws IOException {
        String line = in.readLine();
        if (line == null) throw new IOException();
        linesReadCount.increment();
        return line;
    }

    /**
     * Reads String from BufferedReader and checks if it's valid.
     * @return string input.
     */
    private String askString() throws IOException, WrongInputException {
        String line = readLine();
        if (nameValidator.notValid(line)) {
            throw new WrongInputException();
        }
        return line;
    }

    /**
     * Reads name and checks if it's valid.
     * @return name
     */
    @Override
    public String askName() throws IOException, WrongInputException {
        String line = readLine();
        if (nameValidator.notValid(line)) {
            throw new WrongInputException();
        }
        return line;
    }
    /**
     * Reads X coordinate and checks if it's valid.
     * @return X coordinate
     */
    private Double askX() throws IOException, WrongInputException {
        String line = readLine();
        Double x = null;
        try {
            x = Double.parseDouble(line);
        } catch (NumberFormatException e) {
            throw new WrongInputException("Wrong number at line " + in.getLineNumber());
        }

        if (coordinatesValidator.notValidX(x)) {
            throw new WrongInputException();
        }
        return x;
    }
    /**
     * Reads Y coordinate and checks if it's valid.
     * @return Y coordinate
     */
    private Double askY() throws IOException, WrongInputException {
        String line = readLine();
        Double y = null;
        try {
            y = Double.parseDouble(line);
        } catch (NumberFormatException e) {
            throw new WrongInputException("Wrong number at line " + in.getLineNumber());
        }
        if (coordinatesValidator.notValidY(y)) {
            throw new WrongInputException();
        }
        return y;
    }

    /**
     * Creates Coordinates object from X and Y coordinates.
     * @return Coordinates object.
     */
    @Override
    public Coordinates askCoordinates() throws IOException, WrongInputException {
        Double x = askX();
        Double y = askY();
        return new Coordinates(x, y);
    }
    /**
     * Reads annual turnover and checks if it's valid.
     *
     * @return annual turnover
     */
    @Override
    public Long askAnnualTurnover() throws WrongInputException, IOException {
        String line = readLine();
        Long x = null;
        try {
            x = Long.parseLong(line);
        } catch (NumberFormatException e) {
            throw new WrongInputException("Wrong number at line " + in.getLineNumber());
        }
        if (annualTurnoverValidator.notValid(x)) {
            throw new WrongInputException();
        }
        return x;
    }
    /**
     * Reads full name and checks if it's valid.
     * @return full name
     */
    @Override
    public String askFullName() throws IOException, WrongInputException {
        String line = readLine();
        if (fullNameValidator.notValid(line)) {
            throw new WrongInputException();
        }
        return line;
    }
    /**
     * Reads employees count and checks if it's valid.
     *
     * @return employees count
     */
    @Override
    public Long askEmployeesCount() throws IOException, WrongInputException {
        String line = readLine();
        Long x = null;
        try {
            x = Long.parseLong(line);
        } catch (NumberFormatException e) {
            throw new WrongInputException("Wrong number at line " + in.getLineNumber());
        }
        if (employeesCountValidator.notValid(x)) {
            throw new WrongInputException();
        }
        return x;
    }
    /**
     * Reads organization type and checks if it's valid.
     * @return organization type
     */
    @Override
    public OrganizationType askType() throws IOException, WrongInputException {
        String line = readLine();
        return switch (line) {
            case ("PUBLIC") -> OrganizationType.PUBLIC;
            case ("GOVERNMENT") -> OrganizationType.GOVERNMENT;
            case ("OPEN_JOINT_STOCK_COMPANY") -> OrganizationType.OPEN_JOINT_STOCK_COMPANY;
            default -> throw new WrongInputException();
        };
    }
    /**
     * Reads postal address and checks if it's valid.
     * @return postal address
     */
    @Override
    public Address askPostalAddress() throws IOException, WrongInputException {
        String street = askString();
        String zipCode = askString();
        return new Address(street, zipCode);
    }
}
