package com.rendaxx.interrogators;

import com.rendaxx.LineCounter;
import com.rendaxx.collection_object.Address;
import com.rendaxx.collection_object.Coordinates;
import com.rendaxx.collection_object.OrganizationType;
import com.rendaxx.exceptions.WrongInputException;
import com.rendaxx.validators.*;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InterrogatorFile implements Interrogate {

    BufferedReader in;
    LineCounter linesReadCount;
    public InterrogatorFile(BufferedReader br, LineCounter lrc) {
        in = br;
        linesReadCount = lrc;
    }

    private String readLine() throws IOException {
        String line = in.readLine();
        if (line == null) throw new IOException();
        linesReadCount.increment();
        return line;
    }

    private String askString() throws IOException, WrongInputException {
        String line = readLine();
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
        String line = readLine();
        if (!nameValidator.isValid(line)) {
            throw new WrongInputException();
        }
        return line;
    }

    private Double askX() throws IOException, WrongInputException {
        String line = readLine();
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
        String line = readLine();
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
        String line = readLine();
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
        String line = readLine();
        if (!fullNameValidator.isValid(line)) {
            throw new WrongInputException();
        }
        return line;
    }

    @Override
    public long askEmployeesCount() throws IOException, WrongInputException {
        String line = readLine();
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
        String line = readLine();
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
