package ru.innopolis.java.test.homework011;

import java.util.Objects;

public class Automobile {
    private String carNumber;
    private String carModel;
    private String carColor;
    private int carMileage;
    private int carPrice;

    public Automobile(String carNumber, String carModel, String carColor, int carMileage, int carPrice) {
        this.carNumber = carNumber;
        this.carModel = carModel;
        this.carColor = carColor;
        this.carMileage = carMileage;
        this.carPrice = carPrice;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(int carMileage) {
        this.carMileage = carMileage;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Automobile that)) return false;
        return carNumber == that.carNumber && carMileage == that.carMileage && carPrice == that.carPrice && Objects.equals(carModel, that.carModel) && Objects.equals(carColor, that.carColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber, carModel, carColor, carMileage, carPrice);
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "carNumber=" + carNumber +
                ", carModel='" + carModel + '\'' +
                ", carColor='" + carColor + '\'' +
                ", carMileage=" + carMileage +
                ", carPrice=" + carPrice +
                '}';
    }
}
