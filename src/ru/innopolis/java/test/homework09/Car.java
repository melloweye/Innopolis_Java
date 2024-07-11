package ru.innopolis.java.test.homework09;

import java.util.Objects;

public class Car {
    private String make;
    private String model;
    private int year;
    private int horsePower;
    private int acceleration;
    private int suspension;
    private int reliability;

    public Car(String make, String model, int year, int horsePower, int acceleration, int suspension, int reliability) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.horsePower = horsePower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.reliability = reliability;
    }

    public Car() {}

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public int getSuspension() {
        return suspension;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public int getReliability() {
        return reliability;
    }

    public void setReliability(int reliability) {
        this.reliability = reliability;
    }

    @Override
    public String toString() {
        return "Марка: " + make + "; "
                + "год выпуска: " + year + "; "
                + "мощность: " + horsePower + "; "
                + "ускорение: " + acceleration + "; "
                + "подвеска: " + suspension + "; "
                + "долговечность: " + reliability + "; ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return year == car.year && horsePower == car.horsePower && acceleration == car.acceleration && suspension == car.suspension && reliability == car.reliability && Objects.equals(make, car.make) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, year, horsePower, acceleration, suspension, reliability);
    }
}
