package ru.innopolis.java.test.homework09;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            List<Race> races = readRacesFromFile("src/ru/innopolis/java/test/homework09/Input.txt");
            writeRacesToFile("src/ru/innopolis/java/test/homework09/Output.txt", races);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Race> readRacesFromFile(String fileName) throws IOException {
        List<Race> races = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String type = scanner.next();
                int length = scanner.nextInt();
                String route = scanner.next();
                int prize = scanner.nextInt();
                int numCompetitors = scanner.nextInt();
                Car[] cars = new Car[numCompetitors];
                for (int i = 0; i < numCompetitors; i++) {
                    String make = scanner.next();
                    String model = scanner.next();
                    int year = scanner.nextInt();
                    int horsePower = scanner.nextInt();
                    int acceleration = scanner.nextInt();
                    int suspension = scanner.nextInt();
                    int reliability = scanner.nextInt();
                    cars[i] = new Car(make, model, year, horsePower, acceleration, suspension, reliability);
                }
                switch (type) {
                    case "TimeLimitRace":
                        int goldTime = scanner.nextInt();
                        races.add(new TimeLimitRace(length, route, prize, cars, goldTime));
                        break;
                    case "CircuitRace":
                        int laps = scanner.nextInt();
                        races.add(new CircuitRace(length, route, prize, cars, laps));
                        break;
                    case "CasualRace":
                        races.add(new CasualRace(length, route, prize, cars));
                        break;
                    case "DriftRace":
                        races.add(new DriftRace(length, route, prize, cars));
                        break;
                    case "DragRace":
                        races.add(new DragRace(length, route, prize, cars));
                        break;
                }
            }
        }
        return races;
    }

    public static void writeRacesToFile(String fileName, List<Race> races) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Race race : races) {
                writer.write(race.toString());
                writer.newLine();
            }
        }
    }
}
