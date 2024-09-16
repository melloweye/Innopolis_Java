package ru.innopolis.java.test.homework09.race;

import ru.innopolis.java.test.homework09.car.Car;

public class DriftRace extends Race {
    public DriftRace(int length, String route, int prize, Car[] competitorCars) {
        super(length, route, prize, competitorCars);
    }

    public DriftRace() {}

    @Override
    public String toString() {
        return "Дрифтовая гонка.";
    }
}
