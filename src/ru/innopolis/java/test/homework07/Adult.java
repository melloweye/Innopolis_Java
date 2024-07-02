package ru.innopolis.java.test.homework07;

public class Adult extends Person {
    private boolean canBuyOnCredit;

    public Adult(String name, int age, double moneyCash, boolean canBuyOnCredit) {
        super(name, age, moneyCash);
        this.canBuyOnCredit = canBuyOnCredit;
    }

    @Override
    public void addProduct(Product product) {
        if (getMoneyCash() >= product.getProductPrice() || canBuyOnCredit) {
            getProducts().add(product);
            setMoneyCash(getMoneyCash() - product.getProductPrice());
        } else {
            System.out.println(getName() + " не может позволить себе " + product.getProductName());
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
