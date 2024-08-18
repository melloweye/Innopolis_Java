package ru.innopolis.java.test.homework08;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Person {
    private String name;
    private double moneyCash;
    private List<Product> products;

    public Person(String name, double moneyCash) {
        this.moneyCash = moneyCash;
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoneyCash() {
        return moneyCash;
    }

    public void setMoneyCash(int moneyCash) {
        this.moneyCash = moneyCash;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product, BufferedWriter writer) throws IOException {
        if (moneyCash >= product.getProductPrice()) {
            products.add(product);
            moneyCash -= product.getProductPrice();
            writer.write(name + " покупает " + product.getProductName());
            writer.newLine();
        } else {
            writer.write(name + " не может позволить себе " + product.getProductName());
            writer.newLine();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return moneyCash == person.moneyCash && Objects.equals(name, person.name) && Objects.equals(products, person.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, moneyCash, products);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (Product product : products) {
            joiner.add(product.getProductName());
        }
        return name + " - " + (products.isEmpty() ? "Ничего не куплено" : joiner.toString());
    }
}
