package ru.innopolis.java.test.homework012;

import java.util.Objects;

public class PersonManagement {
    private String fullName;
    private String dateOfBirth;
    private long telephoneNumber;
    private char gender;
    private int age;

    public PersonManagement(String fullName, String dateOfBirth, long telephoneNumber, char gender, int age) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.telephoneNumber = telephoneNumber;
        this.gender = gender;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonManagement that)) return false;
        return telephoneNumber == that.telephoneNumber && gender == that.gender && age == that.age && Objects.equals(fullName, that.fullName) && Objects.equals(dateOfBirth, that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, dateOfBirth, telephoneNumber, gender, age);
    }

    @Override
    public String toString() {
        return fullName + " " + dateOfBirth + " " + telephoneNumber + " " + gender + " " + age;
    }
}
