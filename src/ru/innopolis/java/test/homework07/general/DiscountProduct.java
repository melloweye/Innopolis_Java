package ru.innopolis.java.test.homework07.general;

import java.time.LocalDate;
import java.util.Objects;

public class DiscountProduct extends Product {
    private double discount;
    private LocalDate discountEndDate;

    public DiscountProduct(String name, double price, double discount, LocalDate discountEndDate) {
        super(name, price);
        this.discount = discount;
        this.discountEndDate = discountEndDate;
    }

    public double getDiscount() {
        if (LocalDate.now().isAfter(discountEndDate)) {
            return getProductPrice() * (1 - discount / 100);
        } else {
            return getProductPrice();
        }
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public LocalDate getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(LocalDate discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    @Override
    public String toString() {
        return super.toString() + " (скидка: " + discount + "%, до: " + discountEndDate + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountProduct that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(discount, that.discount) == 0 && Objects.equals(discountEndDate, that.discountEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, discountEndDate);
    }
}
