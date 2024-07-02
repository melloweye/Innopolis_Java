package ru.innopolis.java.test.homework07;

public class Child extends Person{
    public Child(String name, int age, double moneyCash) {
        super(name, age, moneyCash);
    }

    @Override
    public void addProduct(Product product) {
        if (getAge() < 6) {
            System.out.println(getName() + " слишком мал, чтобы покупать товары.");
            return;
        }

        if (product.isChildSafe()) {
            if (getMoneyCash() >= product.getProductPrice()) {
                getProducts().add(product);
                setMoneyCash(getMoneyCash() - product.getProductPrice());
                System.out.println(getName() + " покупает " + product.getProductName());
            } else {
                System.out.println(getName() + " не может позволить себе " + product.getProductName());
            }
        } else {
            System.out.println(product.getProductName() + " не доступен для детей.");
        }
    }

    public void setMoneyCash(double moneyCash) {
        try {
            java.lang.reflect.Field moneyField = Person.class.getDeclaredField("moneyCash");
            moneyField.setAccessible(true);
            moneyField.set(this, moneyCash);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
