package ru.innopolis.java.test.homework02.Task1;

import java.util.Locale;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Input degrees in Fahrenheit: ");
        double fahrenheit = scan.nextDouble();
        double celsius = (fahrenheit - 32) * 5/9;

        System.out.printf("%.1f Fahrenheit is %.1f degrees Celsius.", fahrenheit, celsius);
    }
}