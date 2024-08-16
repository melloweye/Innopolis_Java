package ru.innopolis.java.test.attestation.attestation01.model;

import ru.innopolis.java.test.attestation.attestation01.exceptions.PasswordMismatchException;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class User implements Serializable {
    private String id;
    private LocalDateTime creationDate;
    private String login;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private String fatherName;
    private Integer age;
    boolean isWorker;

    public User(String id, String login, String password, String confirmPassword,
                String firstName, String lastName, String fatherName, int age, boolean isWorker) {
        this.id = UUID.randomUUID().toString();
        this.creationDate = LocalDateTime.now();
        setLogin(login);
        setPassword(password);
        setConfirmPassword(confirmPassword);
        setFirstName(firstName);
        setLastName(lastName);
        setFatherName(fatherName);
        setAge(age);
        this.isWorker = isWorker;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || !password.matches("^(?=.*[a-zA-Z])(?=.*\\d).{1,20}$")) {
            throw new IllegalArgumentException("Error password");
        } else {
            this.password = password;
        }
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
       try {
            if (!confirmPassword.equals(password)) {
                throw new PasswordMismatchException("Error password or passwords do not match.");
            } else {
                this.confirmPassword = confirmPassword;
            }
       } catch (PasswordMismatchException e) {
           System.out.println(e.getMessage());
       }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || !firstName.matches("^[а-яА-Яa-zA-Z]+$")) {
            throw new IllegalArgumentException("Error first name");
        } else {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || !lastName.matches("^[а-яА-Яa-zA-Z]+$")) {
            throw new IllegalArgumentException("Error last name");
        } else {
            this.lastName = lastName;
        }
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        if (fatherName != null && !fatherName.matches("^[а-яА-Яa-zA-Z]+$")) {
            throw new IllegalArgumentException("Error father name");
        } else {
            this.fatherName = fatherName;
        }
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        if (age != null && age < 0) {
            throw new IllegalArgumentException("Age must be greater than or equal to 0");
        } else {
            this.age = age;
        }
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return age == user.age && isWorker == user.isWorker && Objects.equals(id, user.id)
                && Objects.equals(creationDate, user.creationDate) && Objects.equals(login, user.login)
                && Objects.equals(password, user.password) && Objects.equals(confirmPassword, user.confirmPassword)
                && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) &&
                Objects.equals(fatherName, user.fatherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, login, password, confirmPassword, firstName, lastName, fatherName, age, isWorker);
    }

    @Override
    public String toString() {
        return id + '|' +
                creationDate + '|' +
                login + '|' +
                password + '|' +
                confirmPassword + '|' +
                firstName + '|' +
                lastName + '|' +
                fatherName + '|' +
                age + '|' +
                isWorker;
    }

}
