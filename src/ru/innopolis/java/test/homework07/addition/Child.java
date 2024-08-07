package ru.innopolis.java.test.homework07.addition;

public class Child extends Person{
    public Child(String name, double moneyCash, int age) {
        super(name, moneyCash, age);
    }

    @Override
    public boolean canBuyProduct(Product product) {
        return getAge() >= 6 && product.isChildSafe();
    }
}
