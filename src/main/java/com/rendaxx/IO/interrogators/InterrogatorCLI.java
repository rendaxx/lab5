package com.rendaxx.IO.interrogators;

import com.rendaxx.utilities.LineCounter;
import com.rendaxx.collection_object.Address;
import com.rendaxx.collection_object.Coordinates;
import com.rendaxx.collection_object.OrganizationType;
import com.rendaxx.exceptions.WrongInputException;
import com.rendaxx.field_validators.*;

import java.io.BufferedReader;
import java.io.IOException;
/**
 * Class for asking user input from command line.
 */
public class InterrogatorCLI implements Interrogate {
    final BufferedReader in;
    final LineCounter linesReadCount;
    public InterrogatorCLI(BufferedReader br, LineCounter lrc) {
        in = br;
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
     * Asks user for string input.
     * @return string input.
     */
    private String askString() throws IOException {
        while (true) {
            String line = readLine();
            try {
                if (nameValidator.notValid(line)) {
                    throw new WrongInputException();
                }
                return line;
            } catch (WrongInputException e) {
                System.err.println("This field can't be empty. Try again.");
            }
        }
    }
    /**
     * Asks user for organization name.
     * @return organization name.
     */
    @Override
    public String askName() throws IOException {
        System.out.println("Enter organization name:");
        return askString();
    }
    /**
     * Asks user for X coordinate.
     * @return X coordinate.
     */
    private Double askX() throws IOException {
        while (true) {
            String line = readLine();
            try {
                Double x = Double.parseDouble(line);
                if (coordinatesValidator.notValidX(x)) {
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
    /**
     * Asks user for Y coordinate.
     * @return Y coordinate.
     */
    private Double askY() throws IOException {
        while (true) {
            String line = readLine();
            try {
                Double y = Double.parseDouble(line);
                if (coordinatesValidator.notValidY(y)) {
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

    /**
     * Asks user for coordinates.
     * @return coordinates.
     */
    @Override
    public Coordinates askCoordinates() throws IOException {
        System.out.println("Enter the X coordinate: ");
        Double x = askX();
        System.out.println("Enter the Y coordinate: ");
        Double y = askY();
        return new Coordinates(x, y);
    }
    /**
     * Asks user for annual turnover.
     * @return annual turnover.
     */
    @Override
    public long askAnnualTurnover() throws IOException {
        System.out.println("Enter annual turnover: ");
        while (true) {
            String line = readLine();
            try {
                long x = Long.parseLong(line);
                if (annualTurnoverValidator.notValid(x)) {
                    throw new WrongInputException();
                }
                return x;
            } catch (NumberFormatException e) {
                System.err.println("Input sequence is not a number. Try again.");
            } catch (WrongInputException e) {
                System.err.println("This field can't be lower than 0. Try again.");
            }
        }
    }
    /**
     * Asks user for full name.
     * @return full name.
     */
    @Override
    public String askFullName() throws IOException {
        System.out.println("Enter the full name: ");
        while (true) {
            String line = readLine();
            try {
                if (fullNameValidator.notValid(line)) {
                    throw new WrongInputException();
                }
                return line;
            } catch (WrongInputException e) {
                System.err.println("Name can't be longer than 1311 symbols. Try again.");
            }
        }
    }
    /**
     * Asks user for employees count.
     * @return employees count.
     */
    @Override
    public long askEmployeesCount() throws IOException {
        System.out.println("Enter employees count:");
        while (true) {
            String line = readLine();
            try {
                long x = Long.parseLong(line);
                if (employeesCountValidator.notValid(x)) {
                    throw new WrongInputException();
                }
                return x;
            } catch (NumberFormatException e) {
                System.err.println("Input sequence is not a number. Try again.");
            } catch (WrongInputException e) {
                System.err.println("This field can't be lower than 0. Try again.");
            }
        }
    }
    /**
     * Asks user for organization type.
     * @return organization type.
     */
    @Override
    public OrganizationType askType() throws IOException {
        System.out.println("Choose organization type:");
        System.out.println("1: PUBLIC");
        System.out.println("2: GOVERNMENT");
        System.out.println("3: OPEN_JOINT_STOCK_COMPANY");
        while (true) {
            String line = readLine();
            try {
                return switch (line) {
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
    /**
     * Asks user for postal address.
     * @return postal address.
     */
    @Override
    public Address askPostalAddress() throws IOException {
        System.out.println("Enter address: ");
        String street = askString();
        System.out.println("Enter zip code: ");
        String zipCode = askString();
        return new Address(street, zipCode);
    }
}
