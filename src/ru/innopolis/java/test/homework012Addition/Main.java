package ru.innopolis.java.test.homework012Addition;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String fullName = null;
        String dateOfBirth = null;
        long mobilePhoneNumber = 0;
        char gender = 0;
        int age = 0;


        // Проверка логина и пароля. По умолчанию передаем правильный пароль и логин
        String login = "validLogin_123";
        String password = "validPassword_123";
        String validatePassword = "validPassword_123";

        // ---------------------------------------------------------------------
        boolean isValid = User.validateUser(login, password, validatePassword);
        if (isValid) {
            System.out.println("Данные верны!");
        } else {
            System.out.println("Ошибка! Данные не верны. Попробуйте снова.");
        }
        // ---------------------------------------------------------------------

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Фамилия Имя Отчество датарождения номертелефона пол возраст: ");
            String input = scanner.nextLine();

            String[] words = input.split(" ");

            if (words.length != 7) {
                throw new ArrayIndexOutOfBoundsException();
            }
            fullName = words[0] + " " + words[1] + " " + words[2];
            dateOfBirth = words[3];
            mobilePhoneNumber = Long.parseLong(words[4]);
            gender = words[5].charAt(0);
            age = Integer.parseInt(words[6]);

            if (!dateOfBirth.matches("\\d{2}.\\d{2}.\\d{4}")) {
                throw new IllegalArgumentException();
            }

            if (words[5].length() != 1 || (gender != 'm' && gender != 'f')) {
                throw new MyCustomException("А вы точно правильно указали пол? У нас можно только 'm' или 'f'");
            }

            PersonManagement person = new PersonManagement(fullName, dateOfBirth, mobilePhoneNumber, gender, age);
            writeToFile(person);

            System.out.println("Данные успешно записаны в файл " + words[0] + ".txt");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Упс! Кажется что-то не так... Перепроверьте введенные данные.");
        } catch (IllegalArgumentException e) {
            System.out.println("Что-то не так с форматом даты рождения... Перепроверьте правильность ввода.");
        } catch (MyCustomException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Упс! Не удалось записать в файл.");
        }

        // Иванов Иван Иванович 08.12.1995 89280112564 m 31
        // Иванов Игорь Иванович 08.08.1965 89280112564 m 72
        // Кузнецов Михаил Иванович 08.11.1987 89280112564 m 35
        // Бабаева Ирина Андреевна 16.08.1912 89280112564 f 110

    }

    private static void writeToFile(PersonManagement person) throws IOException {
        try (FileWriter fileWriter = new FileWriter("/Users/andrew/IdeaProjects/Innopolis_Java/src/ru/innopolis/java/test/homework012/"
                + person.getFullName().split(" ")[0] + ".txt", true)) {
            fileWriter.write(person + "\n");
        }
    }
}



















