package ru.innopolis.java.test.attestation.attestation01;

import ru.innopolis.java.test.attestation.attestation01.model.User;
import ru.innopolis.java.test.attestation.attestation01.repositories.UsersRepositoryFileImpl;

import java.util.List;
import java.util.UUID;

public class App {
    public static void main(String[] args) {
        UsersRepositoryFileImpl usersRepository = new UsersRepositoryFileImpl();

        User user = new User(
                UUID.randomUUID().toString(),
                "ivanov_123",
                "jk1f345vd",
                "jk1f345vd",
                "Иван",
                "Иванов",
                "Иванович",
                20,
                false
        );
        User user1 = new User(
                UUID.randomUUID().toString(),
                "petrov_petr077",
                "goodpassword123",
                "goodpassword123",
                "Петр",
                "Петров",
                "Петрович",
                30,
                true
        );
        User user2 = new User(
                UUID.randomUUID().toString(),
                "igor_sidorov12345",
                "sidorov12345",
                "sidorov12345",
                "Игорь",
                "Сидоров",
                null,
                40,
                true
        );
        User user3 = new User(
                UUID.randomUUID().toString(),
                "random_user111",
                "hello12345",
                "hello12345",
                "Дмитрий",
                "Кузнецов",
                "Валерьевич",
                50,
                false
        );

        try {
            usersRepository.createUser(user);
            usersRepository.createUser(user1);
            usersRepository.createUser(user2);
            usersRepository.createUser(user3);
            System.out.println("Пользователи успешно созданы / записаны в файл");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Пользователь с возрастом 40 найден: " + usersRepository.getByAge(40));


        String toFind = user.getId();
        User foundUser = usersRepository.findById(toFind);
        if (foundUser != null) {
            System.out.println("Пользователь найден: " + foundUser);
        } else {
            System.out.println("Пользователь с id " + toFind + " не найден");
        }

        List<User> users = usersRepository.findAll();
        System.out.println("Полный список пользователей");
        for (User userFound : users) {
            System.out.println(userFound);
        }

        user.setPassword("new_password123");
        user.setConfirmPassword("new_password123");
        user.setId(UUID.randomUUID().toString()); // для проверки работы метода устанавливаем пользователю новый id, которого нет в списке
        usersRepository.updateUser(user);
        System.out.println("Пользователь обновлен " + usersRepository.findById(user.getId()));

        usersRepository.deleteById(user2.getId());
        System.out.println("Пользователь с id " + user2.getId() + " был удален. Список оставшихся: ");
        for (User userFound : usersRepository.findAll()) {
            System.out.println(userFound);
        }

        usersRepository.checkIsWorker(user1);
        usersRepository.checkIsWorker(user3);

        System.out.println("Пользователь с возрастом 50 найден: " + usersRepository.getByAge(50));

//        usersRepository.deleteAll(); // метод закомментирован, чтобы программа писала в файл. Иначе, он будет пустым
//        System.out.println("Все пользователи были удалены из списка. Текущий список: " + usersRepository.findAll());

    }
}
