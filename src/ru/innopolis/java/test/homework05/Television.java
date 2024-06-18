package ru.innopolis.java.test.homework05;

import java.util.Objects;

public class Television {

    private int screenSize;
    private String make;
    private double price;
    private int currentChanel;
    private int currentVolume;
    private boolean isTurnedOn;

    public Television(String make, int screenSize, double price, int currentChanel, int currentVolume, boolean isTurnedOn) {
        this.make = make;
        this.screenSize = screenSize;
        this.price = price;
        this.currentChanel = currentChanel;
        this.currentVolume = currentVolume;
        this.isTurnedOn = isTurnedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Television that)) return false;
        return screenSize == that.screenSize && Double.compare(price, that.price) == 0 && currentChanel == that.currentChanel && currentVolume == that.currentVolume && isTurnedOn == that.isTurnedOn && Objects.equals(make, that.make);
    }

    @Override
    public int hashCode() {
        return Objects.hash(screenSize, make, price, currentChanel, currentVolume, isTurnedOn);
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        isTurnedOn = turnedOn;
    }

    public int getCurrentChanel() {
        return currentChanel;
    }

    public void setCurrentChanel(int currentChanel) {
        this.currentChanel = currentChanel;
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
                ", currentChanel=" + currentChanel +
                ", currentVolume=" + currentVolume +
                ", isTurnedOn=" + isTurnedOn +
                '}';
    }

    void turnOn(){
        System.out.println(this.make + " is on");
    }

    void turnOff(){
        System.out.println(this.make + " is off");
    }
}
