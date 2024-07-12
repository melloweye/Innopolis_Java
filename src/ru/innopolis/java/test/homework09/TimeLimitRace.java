package ru.innopolis.java.test.homework09;

public class TimeLimitRace extends Race {
    private int goldTime;

    public TimeLimitRace(int length, String route, int prize, Car[] competitorCars, int goldTime) {
        super(length, route, prize, competitorCars);
        this.goldTime = goldTime;
    }

    public TimeLimitRace() {}

    public int getGoldTime() {
        return goldTime;
    }

    public void setGoldTime(int goldTime) {
        this.goldTime = goldTime;
    }

    @Override
    public String toString() {
        return "TimeLimitRace{" +
                "goldTime=" + goldTime +
                '}' + super.toString();
    }
}
