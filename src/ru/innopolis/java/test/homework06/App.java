package ru.innopolis.java.test.homework06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Person> people = new ArrayList<>();

        products.add(new Product("Хлеб", 40));
        products.add(new Product("Молоко", 60));
        products.add(new Product("Торт", 1000));
        products.add(new Product("Кофе растворимый", 879));
        products.add(new Product("Масло", 150));
        products.add(new Product("Мороженое", 200));
        products.add(new Product("Макароны", 800));

        people.add(new Person("Павел Андреевич", 10000));
        people.add(new Person("Анна Петровна", 2000));
        people.add(new Person("Борис", 10));
        people.add(new Person("Женя", 0));
        people.add(new Person("Света", -3));

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String personName = scanner.nextLine();
            String productName = scanner.nextLine();

            if (Objects.equals(personName, "end")) {
                break;
            } else {
                for (Person person : people) {
                    if (Objects.equals(personName, person.getPersonName())) {
                        for (Product product : products) {
                            if (Objects.equals(productName, product.getName())) {
                                if (checkAllSituation(people, products)){
                                } else if (checkIfEnoughMoney(person, product)) {
                                    person.addShoppingCart(productName);
                                    System.out.println(person.getPersonName() + " купил " + product.getName());
                                } else {
                                    System.out.println(person.getPersonName() + " не может себе позволить " + product.getName());
                                }
                            }
                        }
                    }
                }
            }
        }
        printResult(people, products);
    }

    public static boolean checkIfEnoughMoney (Person person, Product product) {
        if (person.getHasMoney() < product.getPrice()) {
            return false;
        } else {
            person.setHasMoney(person.getHasMoney() - product.getPrice());
            return true;
        }
    }

    public static void printResult (List<Person> people, List<Product> products) {
        for (Person person : people) {
            for (Product product : products) {
                if (Objects.equals(product.getName(), "")) {
                    System.out.println("Имя не может не может быть пустым");
                } else if (product.getPrice() < 0) {
                    System.out.println("Цена не может быть отрицательной");
                }
                String productsList = person.getShoppingCart().toString();
                if (Objects.equals(person.getPersonName(), "")) {
                    System.out.println("Имя не может быть пустым");
                } else if (person.getHasMoney() < 0) {
                    System.out.println("Деньги не могут быть отрицательными");
                } else if (person.getShoppingCart().isEmpty()) {
                    System.out.println(person.getPersonName() + " ничего не купил");
                } else {
                    System.out.println(person.getPersonName() + " - " + productsList.replace("[", "").replace("]", ""));
                }
            }
        }
    }

    public static boolean checkAllSituation (List<Person> people, List<Product> products) {
        for (Person person : people) {
            for (Product product : products) {
                return person.getPersonName() == "" || person.getHasMoney() < 0 || product.getName() == "" || product.getPrice() < 0;
            }
        }
        return false;
    }
}
