package com.rendaxx.collection_object;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvRecurse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

@Setter
@Getter
@AllArgsConstructor
public class Organization implements Comparable<Organization> {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @CsvBindByPosition(position = 0)
    private String name; //Поле не может быть null, Строка не может быть пустой
    @CsvRecurse
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @CsvBindByPosition(position = 3)
    private long annualTurnover; //Значение поля должно быть больше 0
    @CsvBindByPosition(position = 4)
    private String fullName; //Длина строки не должна быть больше 1311, Поле может быть null
    @CsvBindByPosition(position = 5)
    private long employeesCount; //Значение поля должно быть больше 0
    @CsvBindByPosition(position = 6)
    private OrganizationType type; //Поле может быть null
    @CsvRecurse
    private Address postalAddress; //Поле не может быть null

    public Organization() {
        id = new Random().nextLong(Long.MAX_VALUE);
        creationDate = new Date();
    }

    public boolean validate() {
        if (id == null || id <= 0) return false;
        if (name == null || name.isEmpty()) return false;
        if (coordinates == null || !coordinates.validate()) return false;
        if (creationDate == null) return false;
        if (annualTurnover < 0) return false;
        if (fullName.length() > 1311) return false;
        if (employeesCount < 0) return false;
        if (type == null) return false;
        if (postalAddress == null || !postalAddress.validate()) return false;
        return true;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return annualTurnover == that.annualTurnover && employeesCount == that.employeesCount && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) && Objects.equals(creationDate, that.creationDate) && Objects.equals(fullName, that.fullName) && type == that.type && Objects.equals(postalAddress, that.postalAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, annualTurnover, fullName, employeesCount, type, postalAddress);
    }

    @Override
    public int compareTo(Organization o) {
        return Long.compare(this.annualTurnover, o.annualTurnover);
    }
}
