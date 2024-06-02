package ru.innopolis.java.test.Lesson2.Task2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Input first integer number: ");
        int numOne = scan.nextInt();
        System.out.print("Input second integer number: ");
        int numTwo = scan.nextInt();

        int sum = Integer.sum(numOne, numTwo);
        System.out.println("Сумма двух целых чисел: " + sum);

        int difference = Math.subtractExact(numOne, numTwo);
        System.out.println("Разница двух целых чисел: " + difference);

        int product = Math.multiplyExact(numOne, numTwo);
        System.out.println("Произведение из двух целых чисел: " + product);

        double average = (double)sum / 2;
        System.out.println("Среднее из двух целых чисел: " + average);

        int dist = Math.subtractExact(numOne, numTwo);
        System.out.println("Расстояние двух целых чисел: " + dist);

        int max = Math.max(numOne, numTwo);
        System.out.println("Максимальное целое число:" + max);

        int min = Math.min(numOne, numTwo);
        System.out.println("Минимальное целое число: " + min);
    }
}
