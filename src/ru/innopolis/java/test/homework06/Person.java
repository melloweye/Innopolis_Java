package ru.innopolis.java.test.homework06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String personName;
    private int hasMoney;
    private List<String> shoppingCart = new ArrayList<>();

    public Person(String personName, int hasMoney) {
        this.personName = personName;
        this.hasMoney = hasMoney;
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

    public List<String> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<String> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addShoppingCart(String shoppingCart) {
        this.shoppingCart.add(shoppingCart);
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
        return "Person{" +
                "name='" + personName + '\'' +
                ", hasMoney=" + hasMoney +
                ", products=" + shoppingCart +
                '}';
    }
}

