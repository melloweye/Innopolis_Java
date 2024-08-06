package ru.innopolis.java.test.homework06;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();

/* заготовка для ввода покупателей и продуктов

Павел Андреевич 10000
Анна Петровна 2000
Борис 10
Женя 0
Света -3

Хлеб 40
Молоко 60
Торт 1000
Кофе растворимый 879
Масло 150
Мороженое 200
Макароны 800

*/
/* заготовка для ввода покупок

Павел Андреевич - Хлеб
Павел Андреевич - Масло
Анна Петровна - Кофе растворимый
Анна Петровна - Молоко
Анна Петровна - Молоко
Анна Петровна - Молоко
Анна Петровна - Торт
Борис - Торт
Павел Андреевич - Торт

*/

        System.out.println("Введите имя покупателя и сумму денег. END - для завершения ввода.");
        while (true) {
            String inputString = scanner.nextLine();
            if (inputString.equalsIgnoreCase("END")) {
                break;
            }
            try {
                Person person = createPersonFromInput(inputString);
                people.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Введите название продукта и его стоимость. END - для завершения ввода.");
        while (true) {
            String inputString = scanner.nextLine();
            if (inputString.equalsIgnoreCase("END")) {
                break;
            }
            try {
                Product product = createProductFromInput(inputString);
                products.add(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Покупатели выбирают продукты. Ожидается: 'покупатель - продукт' или END - для завершения ввода.");
        while (true) {
            String inputString = scanner.nextLine();
            if (inputString.equalsIgnoreCase("END")) {
                break;
            }
            try {
                purchaseProduct(people, products, inputString);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for (Person person : people) {
            System.out.println(person);
        }

    }

    // метод для создания покупателя из строки, колученной из консоли
    private static Person createPersonFromInput (String inputString) {
        int lastIndex = inputString.lastIndexOf(" ");
        if (lastIndex == -1) {
            throw new IllegalArgumentException("Неверный формат ввода. Ожидается имя покупателя и сумма денег");
        }
        String personName = inputString.substring(0, lastIndex).trim();
        int money = Integer.parseInt(inputString.substring(lastIndex + 1).trim());

        validatePersonName(personName);
        validatePersonMoney(money);

        return new Person(personName, money);
    }

    // метод для создания продукта из строки, полученной из консоли
    private static Product createProductFromInput (String inputString) {
        int lastIndex = inputString.lastIndexOf(" ");
        if (lastIndex == -1) {
            throw new IllegalArgumentException("Неверный формат ввода. Ожидается название продукта и его стоимость");
        }
        String productName = inputString.substring(0, lastIndex).trim();
        int productPrice = Integer.parseInt(inputString.substring(lastIndex + 1).trim());

        validateProductName(productName);
        validateProductPrice(productPrice);

        return new Product(productName, productPrice);
    }

    // обработка процедуры покупки. сделал в формате: покупатель - продукт
    private static void purchaseProduct(List<Person> people, List<Product> products, String inputString) {
        String[] parts = inputString.split(" - ");

        String personName = parts[0];
        String productName = parts[1];

        Person person = findPersonByName(people, personName);
        Product product = findProductByName(products, productName);

        if (person == null) {
            System.out.println("Покупатель " + personName + " не найден");
        }
        if (product == null) {
            System.out.println("Продукт " + productName + " не найден");
        }

        if (product.getPrice() > person.getHasMoney()) {
            System.out.println(person.getPersonName() + " не может себе позволить " + product.getName());
        } else {
            person.addToShoppingCart(product);
            System.out.println(person.getPersonName() + " покупает " + product.getName());
        }
    }

    // проверка, что имя не пустое
    private static void validatePersonName(String personName) {
        if (personName.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
    }

    // проверка, что деньги не отрицательные
    private static void validatePersonMoney(int personMoney) {
        if (personMoney < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
    }

    // проверка, что название продукта не пустое
    public static void validateProductName (String productName) {
        if (productName.isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
    }

    // проверка, что стоимость продукта не отрицательная
    private static void validateProductPrice(int productPrice) {
        if (productPrice < 0) {
            throw new IllegalArgumentException("Стоимотсь не может быть отрицательной");
        }
    }

    // проверка соответствия покупателя в ранее заполненном списке покупателей с введенным именем для обработки покупки
    private static Person findPersonByName(List<Person> people, String personName) {
        for (Person person : people) {
            if (person.getPersonName().equals(personName)) {
                return person;
            }
        }
        return null;
    }

    // проверка соответствия товара в ранее заполненном списке продуктов с введенным названием для обработки покупки
    private static Product findProductByName(List<Product> products, String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}
