package ru.innopolis.java.test.homework07.addition;

public class Pensioner extends Person {
    private static final double DISCOUNT = 0.05;

    public Pensioner(String name, double moneyCash, int age) {
        super(name, moneyCash, age);
    }

    @Override
    public void addProduct(Product product) {
        double discountedCost = product.getProductPrice() * (1 - DISCOUNT);
        product.setProductPrice(discountedCost);
        super.addProduct(product);
    }

    @Override
    public boolean canBuyProduct(Product product) {
        return product instanceof DiscountProduct;
    }
}
