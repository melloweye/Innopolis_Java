package ru.innopolis.java.test.homework09;

import ru.innopolis.java.test.homework09.car.Car;
import ru.innopolis.java.test.homework09.race.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                int index = 0;
                String type = tokens[index++];
                int length = Integer.parseInt(tokens[index++]);
                String route = tokens[index++];
                int prize = Integer.parseInt(tokens[index++]);
                int numCompetitors = Integer.parseInt(tokens[index++]);

                Car[] cars = new Car[numCompetitors];
                for (int i = 0; i < numCompetitors; i++) {
                    String caeBrand = tokens[index++];
                    String carModel = tokens[index++];
                    int year = Integer.parseInt(tokens[index++]);
                    int horsePower = Integer.parseInt(tokens[index++]);
                    int acceleration = Integer.parseInt(tokens[index++]);
                    int suspension = Integer.parseInt(tokens[index++]);
                    int reliability = Integer.parseInt(tokens[index++]);
                    cars[i] = new Car(caeBrand, carModel, year, horsePower, acceleration, suspension, reliability);
                }
                switch (type) {
                    case "TimeLimitRace":
                        int goldTime = Integer.parseInt(tokens[index++]);
                        races.add(new TimeLimitRace(length, route, prize, cars, goldTime));
                        break;
                    case "CircuitRace":
                        int laps = Integer.parseInt(tokens[index++]);
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