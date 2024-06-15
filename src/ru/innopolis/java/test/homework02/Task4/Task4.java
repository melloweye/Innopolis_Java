package ru.innopolis.java.test.homework02.Task4;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of rows and columns: ");
        int rowsAndCols = scan.nextInt();
        System.out.print("Enter element to repeat: ");
        String symbol = scan.next();

        for (int i = 0; i < rowsAndCols; i++) {
            for (int j = 0; j < rowsAndCols; j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
