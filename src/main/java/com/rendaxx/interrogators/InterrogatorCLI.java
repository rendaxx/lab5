package com.rendaxx.interrogators;

import com.rendaxx.collection_object.Address;
import com.rendaxx.collection_object.Coordinates;
import com.rendaxx.collection_object.OrganizationType;
import com.rendaxx.exceptions.WrongInputException;
import com.rendaxx.validators.annualTurnoverValidator;
import com.rendaxx.validators.coordinatesValidator;
import com.rendaxx.validators.employeesCountValidator;
import com.rendaxx.validators.nameValidator;

import java.io.EOFException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InterrogatorCLI implements Interrogate {
    Scanner in;
    public InterrogatorCLI(Scanner sc) {
        in = sc;
    }

    private String askString() throws EOFException {
        while (true) {
            try {
                if (!in.hasNext()) throw new EOFException();
                String line = in.nextLine();
                if (!nameValidator.isValid(line)) {
                    throw new WrongInputException();
                }
                return line;
            } catch (WrongInputException e) {
                System.err.println("This field can't be empty. Try again.");
            }
        }
    }
    @Override
    public String askName() throws EOFException {
        System.out.println("Enter organization name:");
        return askString();
    }

    private Double askX() throws EOFException {
        while (true) {
            if (!in.hasNext()) throw new EOFException();
            try {
                Double x = Double.parseDouble(in.nextLine());
                if (!coordinatesValidator.isValidX(x)) {
                    throw new WrongInputException();
                }
                return x;
            } catch (NumberFormatException e) {
                System.err.println("Input sequence is not a number. Try again.");
            } catch (WrongInputException e) {
                System.err.println("This number is wrong. Try again.");
            }
        }
    }

    private Double askY() throws EOFException {
        while (true) {
            if (!in.hasNext()) throw new EOFException();
            try {
                Double y = Double.parseDouble(in.nextLine());
                if (!coordinatesValidator.isValidY(y)) {
                    throw new WrongInputException();
                }
                return y;
            } catch (NumberFormatException e) {
                System.err.println("Input sequence is not a number. Try again.");
            } catch (WrongInputException e) {
                System.err.println("This number is wrong. Try again.");
            }
        }
    }


    @Override
    public Coordinates askCoordinates() throws EOFException {
        System.out.println("Enter the X coordinate: ");
        Double x = askX();
        System.out.println("Enter the Y coordinate: ");
        Double y = askY();
        return new Coordinates(x, y);
    }

    @Override
    public long askAnnualTurnover() throws EOFException {
        System.out.println("Enter annual turnover: ");
        while (true) {
            if (!in.hasNext()) throw new EOFException();
            try {
                long x = Long.parseLong(in.nextLine());
                if (!annualTurnoverValidator.isValid(x)) {
                    throw new WrongInputException();
                }
                return x;
            } catch (InputMismatchException e) {
                System.err.println("Input sequence is not a number. Try again.");
            } catch (WrongInputException e) {
                System.err.println("This field can't be lower than 0. Try again.");
            }
        }
    }

    @Override
    public String askFullName() throws EOFException {
        System.out.println("Enter the full name: ");
        while (true) {
            if (!in.hasNext()) throw new EOFException();
            try {
                String name = in.nextLine();
                if (nameValidator.isValid(name)) {
                    throw new WrongInputException();
                }
                return name;
            } catch (WrongInputException e) {
                System.err.println("Name can't be longer than 1311 symbols. Try again.");
            }
        }
    }

    @Override
    public long askEmployeesCount() throws EOFException {
        System.out.println("Enter employees count:");
        while (true) {
            if (!in.hasNext()) throw new EOFException();
            try {
                long x = Long.parseLong(in.nextLine());
                if (!employeesCountValidator.isValid(x)) {
                    throw new WrongInputException();
                }
                return x;
            } catch (InputMismatchException e) {
                System.err.println("Input sequence is not a number. Try again.");
            } catch (WrongInputException e) {
                System.err.println("This field can't be lower than 0. Try again.");
            }
        }
    }

    @Override
    public OrganizationType askType() throws EOFException {
        System.out.println("Choose organization type:");
        System.out.println("1: PUBLIC");
        System.out.println("2: GOVERNMENT");
        System.out.println("3: OPEN_JOINT_STOCK_COMPANY");
        while (true) {
            if (!in.hasNext()) throw new EOFException();
            try {
                String type = in.nextLine();
                return switch (type) {
                    case ("1") -> OrganizationType.PUBLIC;
                    case ("2") -> OrganizationType.GOVERNMENT;
                    case ("3") -> OrganizationType.OPEN_JOINT_STOCK_COMPANY;
                    default -> throw new WrongInputException();
                };
            } catch (WrongInputException e) {
                System.err.println("Choose number from 1 to 3.");
            }
        }
    }

    @Override
    public Address askPostalAddress() throws EOFException {
        System.out.println("Enter address: ");
        String street = askString();
        System.out.println("Enter zip code: ");
        String zipCode = askString();
        return new Address(street, zipCode);
    }
}
