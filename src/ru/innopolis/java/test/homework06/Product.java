package ru.innopolis.java.test.homework06;

import java.util.Objects;

public class Product {
    private String productName;
    private int productPrice;

    public Product(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getName() {
        return productName;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public int getPrice() {
        return productPrice;
    }

    public void setPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return productName == product.productName && productPrice == product.productPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productPrice);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name=" + productName +
                ", price=" + productPrice +
                '}';
    }
}
