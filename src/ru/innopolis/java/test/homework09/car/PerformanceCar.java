package ru.innopolis.java.test.homework09.car;

import java.util.Arrays;
import java.util.Objects;

public class PerformanceCar extends Car {
    private String[] addOns = {};

    public PerformanceCar(String carBrand, String carModel, int year, int horsePower, int acceleration, int suspension, int reliability, String[]addOns) {
        super(carBrand, carModel, year, horsePower, acceleration, suspension, reliability);
        this.addOns = addOns;
        setHorsePower((int) (horsePower * 1.5));
        setSuspension((int) (suspension * 0.75));
    }

    public PerformanceCar() {}

    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns;
    }

    @Override
    public String toString() {
        return "Гоночный автомобиль. Марка: " + getCarBrand() + ';'
                + " модель: " + getCarModel() + ';'
                + " год выпуска: " + getYear() + ';'
                + " разгон, сек.: " + getAcceleration() + ';'
                + " долговечность: " + getReliability() + ';'
                + " дополнения: " + Arrays.toString(addOns) +';'
                + " увеличенная на 50% мощность двигателя: " + getHorsePower() + ';'
                + " уменьшенная на 25% подвеска: " + getSuspension() + ';';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PerformanceCar that)) return false;
        if (!super.equals(o)) return false;
        return Objects.deepEquals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(addOns));
    }
}
