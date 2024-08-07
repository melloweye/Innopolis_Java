package ru.innopolis.java.test.homework07.addition;

import java.time.LocalDate;
import java.util.Objects;

public class DiscountProduct extends Product {
    private double discount;
    private LocalDate discountEndDate;

    public DiscountProduct(String name, double price, boolean childSafe, double discount, LocalDate discountEndDate) {
        super(name, price, childSafe);
        this.discount = discount;
        this.discountEndDate = discountEndDate;
    }

    public double getDiscountedCost() {
        if (LocalDate.now().isBefore(discountEndDate)) {
            return getProductPrice() * (1 - discount / 100);
        }
        return getProductPrice();
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
