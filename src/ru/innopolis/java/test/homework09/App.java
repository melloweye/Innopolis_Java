package ru.innopolis.java.test.homework09;

public class App {
    public static void main(String[] args) {
        Car car = new Car("Ford", "Mustang", 1995, 250, 7, 15, 90);
        System.out.println(car);
        Car car1 = new ShowCar("Opel", "Astra", 2008, 140, 9, 17, 95, 5);
        System.out.println(car1);
        Car car2 = new PerformanceCar("Chevrolet", "Corvette", 2001, 350, 6, 12, 90, new String[]{"Spoiler", "Turbo"});
        System.out.println(car2);

        Car[] competitors = new Car[]{car, car1, car2};

        Race race = new Race(2000, "Monza", 500000, competitors);
        System.out.println(race);
        Race race1 = new DragRace(4000, "Nordschleife", 1200000, competitors);
        System.out.println(race1);

        Garage garage = new Garage(competitors);
        System.out.println(garage);
    }
}
