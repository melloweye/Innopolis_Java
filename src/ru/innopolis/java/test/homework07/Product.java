package ru.innopolis.java.test.homework07;

import java.util.Objects;

public class Product {
    private String productName;
    private double productPrice;
    private boolean childSafe;

    public Product(String productName, double productPrice, boolean childSafe) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.childSafe = childSafe;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isChildSafe() {
        return childSafe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return productPrice == product.productPrice && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productPrice);
    }

    @Override
    public String toString() {
        return productName + ", " + productPrice;
    }
}
