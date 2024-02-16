package com.rendaxx.collection_object;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public record Organization(Long id, String name, Coordinates coordinates,
                           Date creationDate, long annualTurnover, String fullName,
                           long employeesCount, OrganizationType type, Address postalAddress) {
    public Organization(String name, Coordinates coordinates, long annualTurnover, String fullName,
                        long employeesCount, OrganizationType type, Address postalAddress) {
        this(new Random().nextLong(Long.MAX_VALUE), name, coordinates, new Date(), annualTurnover,
                fullName, employeesCount, type, postalAddress);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", annualTurnover=" + annualTurnover +
                ", fullName='" + fullName + '\'' +
                ", employeesCount=" + employeesCount +
                ", type=" + type +
                ", postalAddress=" + postalAddress +
                '}';
    }
}
