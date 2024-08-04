package ru.innopolis.java.test.homework012Addition;

import java.util.Objects;

public class User {
    private String login;
    private String password;
    private String confirmPassword;

    public User(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
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
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(confirmPassword, user.confirmPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, confirmPassword);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }

    public static boolean validateUser(String login, String password, String confirmPassword) {
        try {
            if (!login.matches("^[a-zA-Z0-9_]+$") || (login.length() >= 20)) {
                throw new WrongLoginException("Некорректный логин: Login должен содержать только латинские буквы, цифры и знак подчеркивания");
            }

            if (!password.matches("^[a-zA-Z0-9_]+$") || (password.length() >= 20)) {
                throw new WrongPasswordException("Некорректный пароль: Password должен содержать только латинские буквы, цифрыи знак подчеркивания");
            }

            if (!confirmPassword.equals(password)) {
                throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают");
            }

            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
        return false;
    }

}
