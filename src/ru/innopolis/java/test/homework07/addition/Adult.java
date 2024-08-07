package ru.innopolis.java.test.homework07.addition;

import java.util.Objects;

public class Adult extends Person {
    private boolean canBuyOnCredit;

    public Adult(String name, double moneyCash, int age, boolean canBuyOnCredit) {
        super(name, moneyCash, age);
        this.canBuyOnCredit = canBuyOnCredit;
    }

    public boolean isCanBuyOnCredit() {
        return canBuyOnCredit;
    }

    public void setCanBuyOnCredit(boolean canBuyOnCredit) {
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

    @Override
    public boolean canBuyProduct(Product product) {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adult adult)) return false;
        if (!super.equals(o)) return false;
        return canBuyOnCredit == adult.canBuyOnCredit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), canBuyOnCredit);
    }

    @Override
    public String toString() {
        return getName() + " ничего не купил, потому что покупка в кредит не доступна.";
    }
}
