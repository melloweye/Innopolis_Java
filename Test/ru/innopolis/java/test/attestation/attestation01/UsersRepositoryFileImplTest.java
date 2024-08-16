package ru.innopolis.java.test.attestation.attestation01;

import ru.innopolis.java.test.attestation.attestation01.exceptions.PasswordMismatchException;
import ru.innopolis.java.test.attestation.attestation01.model.User;
import org.junit.jupiter.api.*;
import ru.innopolis.java.test.attestation.attestation01.repositories.UsersRepositoryFileImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsersRepositoryFileImplTest {

    private UsersRepositoryFileImpl usersRepositoryFile;
    private User user, user1;
    private final String fileName = "test.txt";

    @BeforeEach
    public void setUp() {
        usersRepositoryFile = new UsersRepositoryFileImpl();

        user = new User(
                UUID.randomUUID().toString(),
                "user123",
                "jk1fvd",
                "jk1fvd",
                "andrew",
                "perepel",
                "anatoly",
                20,
                false
        );

        user1 = new User(
                UUID.randomUUID().toString(),
                "user1234",
                "jk1fvd0",
                "jk1fvd0",
                "andrew",
                "perepel",
                "anatoly",
                30,
                true
        );

        usersRepositoryFile.createUser(user);
        usersRepositoryFile.createUser(user1);
    }

    @Test
    @Order(2)
    @DisplayName("Поиск пользователя по id")
    public void testFindById() {
        User found = usersRepositoryFile.findById(UUID.randomUUID().toString());
        assertNull(found, "Пользователь с таким id не будет найден");
    }

    @Test
    @Order(1)
    @DisplayName("Поиск всех пользователей")
    public void testFindAll() {
        List<User> users = usersRepositoryFile.findAll();
        assertNotNull(users);
    }

    @Test
    @Order(3)
    @DisplayName("Удаление по id")
    public void testDeleteById() {
        assertNotNull(usersRepositoryFile.findById(user.getId()), "Пользователь не должен быть найден");
        usersRepositoryFile.deleteById(user.getId());
        assertNull(usersRepositoryFile.findById(user.getId()), "Пользователь не должен быть найден");
        assertNotNull(usersRepositoryFile.findById(user1.getId()), "Другие пользователи не должны быть затронуты");
    }

    @Test
    @Order(4)
    @DisplayName("Удаление по id - вызов исключения")
    public void testDeleteById_nonExistingId() {
        assertThrows(NoSuchElementException.class, () -> {
            usersRepositoryFile.deleteById(UUID.randomUUID().toString());
        });
    }

    @Test
    @Order(0)
    @DisplayName("Проверка соответствия паролей (пароль = подтверждение пароля)")
    public void testPasswordMatch() {
        assertThrows(IllegalArgumentException.class, () -> {
            user1.setPassword("random_password");
            user1.setConfirmPassword("jk1fvd0");
        }, "Ожидается исключение при не совпадении паролей.");
    }

    @AfterEach
    public void tearDown() {
        usersRepositoryFile = null;
        user = null;
    }
}