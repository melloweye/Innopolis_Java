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

        System.out.println("Введите данные покупателя через пробел в формате: [имя] [сумма денег] [возраст] [взрослый/ребенок/пенсионер] [возможна ли скидка: true/false] ");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            String[] personData = input.split(" ");
            String personName = personData[0];
            double personMoney;
            int personAge;
            String personType = personData[3];
            boolean canBuyOnCredit = personData.length > 4 && Boolean.parseBoolean(personData[4]);

            try {
                personMoney = Double.parseDouble(personData[1]);
                personAge = Integer.parseInt(personData[2]);
                validatePerson(personName, personMoney, personAge);

                switch (personType) {
                    case "ребенок":
                        validateChild(personAge);
                        people.add(new Child(personName, personAge, personMoney));
                        break;
                    case "взрослый":
                        validateAdult(personAge);
                        people.add(new Adult(personName, personAge, personMoney, canBuyOnCredit));
                        break;
                    case "пенсионер":
                        validatePensioner(personAge);
                        people.add(new Pensioner(personName, personAge, personMoney));
                        break;
                    default:
                        System.out.println("Неверный тип покупателя");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Введите данные продуктов в формате: [название] [стоимость] [доступен для ребенка: true/false] [скидочный/обычный] [размер скидки] [срок действия скидки]");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            String[] productData = input.split(" ");
            String productName = productData[0];
            double productPrice;
            boolean childSafe = Boolean.parseBoolean(productData[2]);

            try {
                productPrice = Double.parseDouble(productData[1]);
                validateProduct(productName, productPrice);

                String productType = productData[3];
                if (productType.equalsIgnoreCase("обычный")) {
                    products.add(new Product(productName, productPrice, childSafe));
                } else if (productType.equalsIgnoreCase("скидочный")) {
                    double discount = Double.parseDouble(productData[4]);
                    LocalDate discountEndDate = LocalDate.parse(productData[5]);
                    validateDiscountProduct(discount);
                    products.add(new DiscountProduct(productName, productPrice, childSafe, discount, discountEndDate));
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

    private static void validatePerson(String personName, double personMoney, int personAge) {
        if (personName == null || personName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (personMoney < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        if (personAge < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательный");
        }
    }

    private static void validateChild(int age) {
        if (age < 0 || age > 17) {
            throw new IllegalArgumentException("Возраст ребенка должен быть от 0 до 17 лет");
        }
    }

    private static void validateAdult (int age) {
        if (age < 18 || age > 65) {
            throw new IllegalArgumentException("Возрвст взрослого должен быть от 18 до 65 лет");
        }
    }

    private static void validatePensioner (int age) {
        if (age < 65) {
            throw new IllegalArgumentException("Пенсионер не может быть моложе 65 лет");
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