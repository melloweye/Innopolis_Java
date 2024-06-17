package ru.innopolis.java.test.homework05;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Television> televisionArrayList = new ArrayList<Television>();
        String make = null;
        int screenSize = 0;
        double price = 0;
        int currentChanel = 0;
        int currentVolume = 0;
        int maxVolume = 70;
        boolean isTurnedOn = false;
        int numOfTV = scanner.nextInt();
        for (int i = 0; i < numOfTV; i++) {
            scanner.nextLine();
            System.out.print("Input TV maker name: ");
            make = scanner.nextLine();
            System.out.print("Input screen size that you want to buy: ");
            screenSize = scanner.nextInt();
            System.out.print("Input price that you can afford to buy a TV: ");
            price = scanner.nextInt();
            System.out.print("Choose the chanel number: ");
            currentChanel = scanner.nextInt();
            System.out.print("Choose chanel volume 0 to 100: ");
            currentVolume = scanner.nextInt();
            System.out.print("Is TV turned on? ");
            isTurnedOn = scanner.nextBoolean();
            televisionArrayList.add(new Television(make, screenSize, price, currentChanel, currentVolume, isTurnedOn));
        }
        scanner.close();

        //получаем значения с клавиатуры
        Television tv1 = new Television(make, screenSize, price, currentChanel, currentVolume, isTurnedOn);
        Television tv2 = new Television(make, screenSize, price, currentChanel, currentVolume, isTurnedOn);
        Television tv3 = new Television(make, screenSize, price, currentChanel, currentVolume, isTurnedOn);
        Television tv4 = new Television(make, screenSize, price, currentChanel, currentVolume, isTurnedOn);
        Television tv5 = new Television(make, screenSize, price, currentChanel, currentVolume, isTurnedOn);
        Television tv6 = new Television(make, screenSize, price, currentChanel, currentVolume, isTurnedOn);
        Television tv7 = new Television(make, screenSize, price, currentChanel, currentVolume, isTurnedOn);
        Television tv8 = new Television(make, screenSize, price, currentChanel, currentVolume, isTurnedOn);
        Television tv9 = new Television(make, screenSize, price, currentChanel, currentVolume, isTurnedOn);
        Television tv10 = new Television(make, screenSize, price, currentChanel, currentVolume, isTurnedOn);

        for (Television television : televisionArrayList) {
            if (television.isTurnedOn() && (television.getCurrentVolume() < maxVolume)) {
                System.out.println(television + " соответствует всем условиям и поэтому мы его печатаем"); // Выводится в консоль. Условие выполняется
            }
        }

        // System.out.println(tv2 + " этот по идее не должен печататься."); //для проверки, что все утловия выполняются. Это не печатается
    }
}
