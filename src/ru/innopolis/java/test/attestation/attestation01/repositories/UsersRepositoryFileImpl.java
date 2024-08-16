package ru.innopolis.java.test.attestation.attestation01.repositories;

import ru.innopolis.java.test.attestation.attestation01.model.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UsersRepositoryFileImpl implements UsersRepository {

    private static final String FILE_PATH = "src/ru/innopolis/java/test/attestation/attestation01/users.txt";

    private final List<User> users = new ArrayList<>();

    @Override
    public void createUser(User user) {
        boolean loginExists = users.stream().anyMatch(u -> u.getLogin().equals(user.getLogin()));
        if (loginExists) {
            throw new IllegalArgumentException("User with login " + user.getLogin() + " already exists");
        }
        users.add(user);
        saveToFile();
    }

    @Override
    public User findById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        } return null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void updateUser(User user) {
        User existingUser = findById(user.getId());
        if (existingUser == null) {
            System.out.println("Пользователь не найден");
            createUser(user);
        } else {
            existingUser.setLogin(user.getLogin());
            existingUser.setPassword(user.getPassword());
            existingUser.setConfirmPassword(user.getConfirmPassword());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setFatherName(user.getFatherName());
            existingUser.setAge(user.getAge());
            existingUser.setWorker(user.isWorker());
        }

        saveToFile();
    }

    @Override
    public void deleteById(String id) {
        User user = findById(id);
        if (user != null) {
            users.remove(user);
            saveToFile();
        } else {
            throw new NoSuchElementException("Пользователь с заданным id не существует");
        }
    }

    @Override
    public void deleteAll() {
        users.clear();
        saveToFile();
    }

    public User getByAge(int age) { // опциональный метод поиска пользователя по возрасту
        for (User user : users) {
            if (user.getAge() == age) {
                return user;
            }
        } return null;
    }

    public void checkIsWorker(User user) { // опциональный метод проверки, является ли пользователь работником
        if (user.isWorker()) {
            System.out.println("Пользователь - [" + user + "] - работник");
        } else {
            System.out.println("Пользователь - [" + user + "] - не работник");
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : users) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи в файл", e);
        }
    }
}
