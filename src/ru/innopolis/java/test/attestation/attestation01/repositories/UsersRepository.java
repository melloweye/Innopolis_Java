package ru.innopolis.java.test.attestation.attestation01.repositories;

import ru.innopolis.java.test.attestation.attestation01.model.User;

import java.util.List;

public interface UsersRepository {
    void createUser(User user);

    User findById(String id);

    List<User> findAll();

    void updateUser(User user);

    void deleteById(String id);

    void deleteAll();
}
