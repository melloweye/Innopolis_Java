package ru.innopolis.java.test.homework09.race;

import ru.innopolis.java.test.homework09.car.Car;

import java.util.Arrays;
import java.util.Objects;

public class Race {
    private int length;
    private String route;
    private int prize;
    private Car[] competitorCars;

    public Race(int length, String route, int prize, Car[] competitorCars) {
        this.length = length;
        this.route = route;
        this.prize = prize;
        this.competitorCars = competitorCars;
    }

    public Race() {}

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public Car[] getCompetitorCars() {
        return competitorCars;
    }

    public void setCompetitorCars(Car[] competitorCars) {
        this.competitorCars = competitorCars;
    }

    @Override
    public String toString() {
        return "Длина: " + length + ';'
                + " маршрут: " + route + ';'
                + " призовой фонд: " + prize + ';'
                + " участники: " + Arrays.toString(competitorCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Race race)) return false;
        return length == race.length && prize == race.prize && Objects.equals(route, race.route) && Objects.deepEquals(competitorCars, race.competitorCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, route, prize, Arrays.hashCode(competitorCars));
    }
}
