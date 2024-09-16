package ru.innopolis.java.test.homework09.car;

import java.util.Objects;

public class ShowCar extends Car {
    private int stars = 0;

    public ShowCar(String carBrand, String carModel, int year, int horsePower, int acceleration, int suspension, int reliability, int stars) {
        super(carBrand, carModel, year, horsePower, acceleration, suspension, reliability);
        this.stars = stars;
    }

    public ShowCar() {}

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return "Спортивная машина. " +
                "Популярность " + stars + ". " +
                super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShowCar showCar)) return false;
        if (!super.equals(o)) return false;
        return stars == showCar.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }
}
