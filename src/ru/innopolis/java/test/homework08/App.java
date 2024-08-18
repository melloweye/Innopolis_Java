package ru.innopolis.java.test.homework08;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        List<String> shoppingRequest = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/ru/innopolis/java/test/homework08/Input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("src/ru/innopolis/java/test/homework08/Output.txt"))) {
            String line;

            List<Person> persons = readPersonsFromLine(reader);
            List<Product> products = readProductsFromLine(reader);


            while ((line = reader.readLine()) != null && !line.equalsIgnoreCase("END")) {
                shoppingRequest.add(line.trim());
            }

            for (String request : shoppingRequest) {
                String[] parts = request.split(" - ");
                if (parts.length != 2) {
                    System.out.println("Invalid request format: " + request);
                    continue;
                }

                String personName = parts[0];
                String productName = parts[1];

                Person person = findPersonByName(persons, personName);
                Product product = findProductByName(products, productName);

                if (person != null && product != null) {
                    person.addProduct(product, writer);
                } else {
                    System.out.println("Invalid person or product: " + request);
                }
            }

            for (Person person : persons) {
                writer.write(person.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Person> readPersonsFromLine(BufferedReader reader) throws IOException {
        List<Person> personList = new ArrayList<>();
        String line;
        if ((line = reader.readLine()) != null) {
            String[] parts = line.split("; ");
            for (String part : parts) {
                String[] keyValue = part.split(" = ");
                if (keyValue.length == 2) {
                    String name = keyValue[0].trim();
                    String valueString = keyValue[1].trim();
                    try {
                        double money = Double.parseDouble(valueString);
                        personList.add(new Person(name, money));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format for: " + keyValue[1]);
                    }
                }
            }
        }
        return personList;
    }

    private static List<Product> readProductsFromLine(BufferedReader reader) throws IOException {
        List<Product> productList = new ArrayList<>();
        String line;
        if ((line = reader.readLine()) != null) {
            String[] parts = line.split("; ");
            for (String part : parts) {
                String[] keyValue = part.split(" = ");
                if (keyValue.length == 2) {
                    String name = keyValue[0].trim();
                    String valueString = keyValue[1].trim();
                    try {
                        double price = Double.parseDouble(valueString);
                        productList.add(new Product(name, price));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format for: " + keyValue[1]);
                    }
                }
            }
        }
        return productList;
    }


    private static Person findPersonByName(List<Person> persons, String name) {
        for (Person person : persons) {
            if (person.getName().equals(name)) {
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

