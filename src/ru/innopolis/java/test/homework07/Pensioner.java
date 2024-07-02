package ru.innopolis.java.test.homework07;

import java.io.FileNotFoundException;

public class Pensioner extends Person {
    private static final double DISCOUNT = 0.05;

    public Pensioner(String name, int age, double moneyCash) {
        super(name, age, moneyCash);
    }

    @Override
    public void addProduct(Product product) {
        if (product instanceof DiscountProduct) {
            double discountPrice = product.getProductPrice() * (1 - DISCOUNT);
            if (getMoneyCash() >= discountPrice) {
                getProducts().add(product);
                setMoneyCash(getMoneyCash() - discountPrice);
            } else {
                System.out.println(getName() + " не может позволить себе " + product.getProductName());
            }
        } else {
            System.out.println(getName() + " Покупает только скидочные продукты");
        }
    }

    private void setMoney (double moneyCash) {
        try {
            java.lang.reflect.Field moneyField = Person.class.getDeclaredField("moneyCash");
            moneyField.setAccessible(true);
            moneyField.set(this, moneyCash);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
