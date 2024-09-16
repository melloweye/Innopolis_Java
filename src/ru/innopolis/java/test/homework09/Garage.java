package ru.innopolis.java.test.homework09;

import ru.innopolis.java.test.homework09.car.Car;

import java.util.Arrays;
import java.util.Objects;

public class Garage {
    private Car[] parkedCars;

    public Garage(Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }

    public Garage() {
    }

    public Car[] getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(Car[] parkedCars) {
        this.parkedCars = parkedCars;
    }

    public void modifyParkedCars(int index, Car car) {
        if (index >= 0 && index < parkedCars.length) {
            parkedCars[index] = car;
        }
    }

    @Override
    public String toString() {
        return "Машины в гараже: " + Arrays.toString(parkedCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Garage garage)) return false;
        return Objects.equals(parkedCars, garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(parkedCars);
    }
}
