package ru.innopolis.java.test.homework03;

import java.util.Scanner;

public class App {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input TV maker name: ");
        String make = scanner.nextLine();
        System.out.print("Input screen size that you want to buy: ");
        int screenSize = scanner.nextInt();
        System.out.print("Input price that you can afford to buy a TV: ");
        double price = scanner.nextInt();
        scanner.close();

        //получаем значения с клавиатуры
        Television tv1 = new Television(make, screenSize, price);
        //задаем изначальные значения вручную
        Television tv2 = new Television("Samsung", 32, 12990.00);

        // напечатал для примера все атрибуты отдельно взятого телевизора, а также пример переопреления методов
        //печатаем то, что получили с клавиатуры
        System.out.println();
        System.out.println("Well, we've got a " + tv1.getMake() + " TV" + " with a screen of " + tv1.getScreenSize() +
                " inches for only " + tv1.getPrice() + " rubles\n");
        //печатаем то, что задали самостоятельно
        System.out.println("And this is a " + tv2.getMake() + " TV" + " with a screen of " + tv2.getScreenSize() +
                " inches and it costs " + tv2.getPrice() + "\n");

        // ниже состояния телевизоров (методы)
        tv1.turnOn();
        tv2.turnOff();
        System.out.println();
        // Переопределение метода toString()
        System.out.println(tv1.toString()); //implicit usage
        System.out.println(tv2); // explicit usage
    }
}
