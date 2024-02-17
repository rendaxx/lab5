package com.rendaxx.interrogators;

import com.rendaxx.collection_object.Address;
import com.rendaxx.collection_object.Coordinates;
import com.rendaxx.collection_object.OrganizationType;
import com.rendaxx.exceptions.WrongInputException;
import com.rendaxx.validators.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InterrogatorFile implements Interrogate {

    BufferedReader in;
    public InterrogatorFile(BufferedReader br) {
        in = br;
    }

    private String askString() throws IOException, WrongInputException {
        String line = in.readLine();
        if (line == null) throw new IOException();
        try {
            if (!nameValidator.isValid(line)) {
                throw new WrongInputException();
            }
            return line;
        } catch (WrongInputException e) {
            throw new WrongInputException();
        }
    }
    @Override
    public String askName() throws IOException, WrongInputException {
        String line = in.readLine();
        if (line == null) throw new IOException();
        if (!nameValidator.isValid(line)) {
            throw new WrongInputException();
        }
        return line;
    }

    private Double askX() throws IOException, WrongInputException {
        String line = in.readLine();
        if (line == null) throw new IOException();
        try {
            Double x = Double.parseDouble(line);
            if (!coordinatesValidator.isValidX(x)) {
                throw new WrongInputException();
            }
            return x;
        } catch (NumberFormatException e) {
            throw new WrongInputException();
        }
    }

    private Double askY() throws IOException, WrongInputException {
        String line = in.readLine();
        if (line == null) throw new IOException();
        try {
            Double y = Double.parseDouble(line);
            if (!coordinatesValidator.isValidY(y)) {
                throw new WrongInputException();
            }
            return y;
        } catch (NumberFormatException e) {
            throw new WrongInputException();
        }
    }
    @Override
    public Coordinates askCoordinates() throws IOException, WrongInputException {
        Double x = askX();
        Double y = askY();
        return new Coordinates(x, y);
    }

    @Override
    public long askAnnualTurnover() throws WrongInputException, IOException {
        String line = in.readLine();
        if (line == null) throw new IOException();
        try {
            long x = Long.parseLong(line);
            if (!annualTurnoverValidator.isValid(x)) {
                throw new WrongInputException();
            }
            return x;
        } catch (InputMismatchException e) {
            throw new WrongInputException();
        }
    }

    @Override
    public String askFullName() throws IOException, WrongInputException {
        String line = in.readLine();
        if (line == null) throw new IOException();
        if (!fullNameValidator.isValid(line)) {
            throw new WrongInputException();
        }
        return line;
    }

    @Override
    public long askEmployeesCount() throws IOException, WrongInputException {
        String line = in.readLine();
        if (line == null) throw new IOException();
        try {
            long x = Long.parseLong(line);
            if (!employeesCountValidator.isValid(x)) {
                throw new WrongInputException();
            }
            return x;
        } catch (InputMismatchException e) {
            throw new WrongInputException();
        }
    }

    @Override
    public OrganizationType askType() throws IOException, WrongInputException {
        String line = in.readLine();
        if (line == null) throw new IOException();
        return switch (line) {
            case ("PUBLIC") -> OrganizationType.PUBLIC;
            case ("GOVERNMENT") -> OrganizationType.GOVERNMENT;
            case ("OPEN_JOINT_STOCK_COMPANY") -> OrganizationType.OPEN_JOINT_STOCK_COMPANY;
            default -> throw new WrongInputException();
        };
    }

    @Override
    public Address askPostalAddress() throws IOException, WrongInputException {
        String street = askString();
        String zipCode = askString();
        return new Address(street, zipCode);
    }
}
