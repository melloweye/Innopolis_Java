package ru.innopolis.java.test.homework06;

import java.util.*;

public class Person {
    private String personName;
    private int hasMoney;
    private List<Product> shoppingCart;

    public Person(String personName, int hasMoney) {
        this.personName = personName;
        this.hasMoney = hasMoney;
        this.shoppingCart = new ArrayList<>();
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getHasMoney() {
        return hasMoney;
    }

    public void setHasMoney(int hasMoney) {
        this.hasMoney = hasMoney;
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addToShoppingCart(Product product) {
        this.shoppingCart.add(product);
        this.hasMoney -= product.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return hasMoney == person.hasMoney && Objects.equals(personName, person.personName) && Objects.equals(shoppingCart, person.shoppingCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personName, hasMoney, shoppingCart);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (Product product : shoppingCart) {
            joiner.add(product.getName());
        }
        return personName + " - " + (shoppingCart.isEmpty() ? "Ничего не куплено" : joiner.toString());
    }
}

