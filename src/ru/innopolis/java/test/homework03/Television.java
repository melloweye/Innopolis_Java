package ru.innopolis.java.test.homework03;

public class Television {

    private int screenSize;
    private String make;
    private double price;

    public Television(String make, int screenSize, double price) {
        this.make = make;
        this.screenSize = screenSize;
        this.price = price;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Television {" +
                "screenSize=" + screenSize +
                ", make='" + make + '\'' +
                ", price=" + price +
                '}';
    }

    void turnOn(){
        System.out.println(this.make + " is on");
    }

    void turnOff(){
        System.out.println(this.make + " is off");
    }
}
