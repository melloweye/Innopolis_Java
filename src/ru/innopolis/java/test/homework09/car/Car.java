package ru.innopolis.java.test.homework09.car;

import java.util.Objects;

public class Car {
    private String carBrand;
    private String carModel;
    private int year;
    private int horsePower;
    private int acceleration;
    private int suspension;
    private int reliability;

    public Car(String carBrand, String carModel, int year, int horsePower, int acceleration, int suspension, int reliability) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.year = year;
        this.horsePower = horsePower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.reliability = reliability;
    }

    public Car() {}

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
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
        return "Car{" +
                "make='" + carBrand + '\'' +
                ", model='" + carModel + '\'' +
                ", year=" + year +
                ", horsePower=" + horsePower +
                ", acceleration=" + acceleration +
                ", suspension=" + suspension +
                ", reliability=" + reliability +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return year == car.year && horsePower == car.horsePower && acceleration == car.acceleration && suspension == car.suspension && reliability == car.reliability && Objects.equals(carBrand, car.carBrand) && Objects.equals(carModel, car.carModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carBrand, carModel, year, horsePower, acceleration, suspension, reliability);
    }
}
