package ru.innopolis.java.test.homework09;

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
