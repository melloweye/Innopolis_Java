package ru.innopolis.java.test.homework07.addition;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class Person {
    private String name;
    private int age;
    private double moneyCash;
    private List<Product> products;

    public Person(String name, double moneyCash, int age) {
        this.age = age;
        this.moneyCash = moneyCash;
        this.name = name;
        this.products = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public void setMoneyCash(double moneyCash) {
        this.moneyCash = moneyCash;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
        moneyCash -= product.getProductPrice();
    }

    public abstract boolean canBuyProduct(Product product);

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
