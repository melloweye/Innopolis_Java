package ru.innopolis.java.test.homework07.addition;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        System.out.println("Введите данные покупателя через пробел в формате: [имя] [сумма денег] [возраст]. END - для завершения ввода");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            try {
                Person person = createPersonFromInput(input);
                people.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Введите данные продуктов в формате: " +
                "[название] [стоимость] [доступен для ребенка: true/false] [размер скидки] [срок действия скидки]. " +
                "END - для завершения ввода");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            try {
                Product product = createProductFromInput(input);
                products.add(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Покупатели выбирают продукты. Введите имя покупателя и продукт через пробел. END - для завершения ввода");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            try {
                purchaseProduct(people, products, input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        for (Person person : people) {
            System.out.println(person);
        }
    }

    private static Person createPersonFromInput(String input) {
        String[] data = input.split(" ");
        if (data.length < 3) {
            throw new IllegalArgumentException("Неверный формат ввода. Ожидается имя сумма денег возраст");
        }
        String name = data[0];
        double money = Double.parseDouble(data[1]);
        int age = Integer.parseInt(data[2]);

        validateName(name);
        validateMoney(money);
        validateAge(age);

        if (age < 18) {
            return new Child(name, money, age);
        } else if (age < 65) {
            return new Adult(name, money, age, true); // в данном случае ситуация, когда взрослый не может ничего покупать,
                                                                            // потому что покупка в кредит для него не доступна
        } else {
            return new Pensioner(name, money, age);
        }
    }

    private static Product createProductFromInput(String input) {
        String[] data = input.split(" ");
        if (data.length < 3) {
            throw new IllegalArgumentException("Неверный формат ввода. " +
                    "Ожидается название продукта стоимость доступность для детей");
        }
        String name = data[0];
        double price = Double.parseDouble(data[1]);
        boolean childSafe = Boolean.parseBoolean(data[2]);

        validateProduct(name);
        validatePrice(price);

        if (data.length == 3) {
            return new Product(name, price, childSafe);
        } else if (data.length == 5) {
            double discountedPrice = Double.parseDouble(data[3]);
            LocalDate endDate;
            try {
                endDate = LocalDate.parse(data[4]);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Неверный формат даты. Ожидается ГГГГ-ММ-ДД");
            }
            validateDiscountPercentage(discountedPrice);
            return new DiscountProduct(name, price, childSafe, discountedPrice, endDate);
        } else {
            throw new IllegalArgumentException("Неверный формат ввода. " +
                    "Ожидается название продукта стоимость доступность для детей процент скидки срок действия скидки");
        }
    }

    private static void purchaseProduct(List<Person> people, List<Product> products, String input) {
        String[] data = input.split(" ");
        if (data.length != 2) {
            throw new IllegalArgumentException("Неверный формат ввода. Ожидается имя покупателя и название продукта");
        }
        String name = data[0];
        String productName = data[1];

        Person person = findPersonByName(people, name);
        Product product = findProductByName(products, productName);

        if (person == null) {
            throw new IllegalArgumentException("Покупатель " + name + " не найден");
        }
        if (product == null) {
            throw new IllegalArgumentException("Продукт " + productName + " не найден");
        }

        if (!person.canBuyProduct(product)) {
            System.out.println(person.getName() + " не может купить " + product.getProductName());
        } else {
            double productPrice = (product instanceof DiscountProduct) ? ((DiscountProduct) product).getDiscountedCost() : product.getProductPrice();
            if (productPrice > person.getMoneyCash()) {
                System.out.println(person.getName() + " не может позволить себе " + product.getProductName());
            } else {
                person.addProduct(product);
                System.out.println(person.getName() + " купил " + product.getProductName());
            }
        }
    }

    private static void validateName(String name) {
        if (name.isEmpty() || name.matches("\\d+") || name.length() < 3) {
            throw new IllegalArgumentException("Неверное имя покупателя");
        }
    }

    private static void validateMoney(double money) {
        if (money <= 0) {
            throw new IllegalArgumentException("Деньги не могут быть нулевыми или отрицательными");
        }
    }

    private static void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
    }

    private static void validateProduct(String name) {
        if (name.isEmpty() || name.matches("\\d+") || name.length() < 3) {
            throw new IllegalArgumentException("Неверное название продукта");
        }
    }

    private static void validatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Стоимость не может быть нулевой или отрицательной");
        }
    }

    private static void validateDiscountPercentage(double discountedPrice) {
        if (discountedPrice <= 0 || discountedPrice > 100) {
            throw new IllegalArgumentException("Процент скидки не может быть меньше 0 и больше 100");
        }
    }

    private static Person findPersonByName(List<Person> people, String personName) {
        for (Person person : people) {
            if (person.getName().equals(personName)) {
                return person;
            }
        }
        return null;
    }

    // проверка соответствия товара в ранее заполненном списке продуктов с введенным названием для обработки покупки
    private static Product findProductByName(List<Product> products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}