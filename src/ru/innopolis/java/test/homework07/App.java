package ru.innopolis.java.test.homework07;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        System.out.println("Введите имя покупателя и сумму денег через пробел: ");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            String[] personData = input.split(" ");
            String personName = personData[0];
            double personMoney;

            try {
                personMoney = Double.parseDouble(personData[1]);
                validatePerson(personName, personMoney);
                people.add(new Person(personName, personMoney));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Введите данные продуктов в формате: [название] [стоимость] [скидочный/обычный] [размер скидки] [срок действия скидки]");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            String[] productData = input.split(" ");
            String productName = productData[0];
            double productPrice;

            try {
                productPrice = Double.parseDouble(productData[1]);
                validateProduct(productName, productPrice);

                String productType = productData[2];
                if (productType.equalsIgnoreCase("обычный")) {
                    products.add(new Product(productName, productPrice));
                } else if (productType.equalsIgnoreCase("скидочный")) {
                    double discount = Double.parseDouble(productData[3]);
                    LocalDate discountEndDate = LocalDate.parse(productData[4]);
                    validateDiscountProduct(discount);
                    products.add(new DiscountProduct(productName, productPrice, discount, discountEndDate));
                } else {
                    System.out.println("Неверный тип продукта");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Покупатели выбирают продукты. Введите имя покупателя и продукт через пробел: ");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            String[] purchaseData = input.split(" ");
            String personName = purchaseData[0];
            String productName = purchaseData[1];

            Person person = findPersonByName(people, personName);
            Product product = findProductByName(products, productName);

            if (person != null && product != null) {
                person.addProduct(product);
            } else {
                System.out.println("Неверные данные. Проверьте правилность и повторите ввод");
            }
        }

        for (Person person : people) {
            System.out.println(person);
        }
    }

    private static void validatePerson(String personName, double personMoney) {
        if (personName == null || personName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (personMoney < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
    }

    private static void validateProduct(String productName, double productPrice) {
        if (productName == null || productName.trim().isEmpty() || productName.matches("\\d+") || productName.length() < 3) {
            throw new IllegalArgumentException("Недействительное название продукта");
        }
        if (productPrice <= 0) {
            throw new IllegalArgumentException("Стоимость не может быть нулевой или отрицательной");
        }
    }

    private static void validateDiscountProduct(double discount) {
        if (discount <= 0) {
            throw new IllegalArgumentException("Скидка не может быть нулевой или отрицательной");
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
    private static Product findProductByName(List<Product> products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}