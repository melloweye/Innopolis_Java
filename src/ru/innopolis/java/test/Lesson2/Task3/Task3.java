package ru.innopolis.java.test.Lesson2.Task3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter string: ");
        String stringSample = scan.nextLine();
        System.out.print("How many times to repeat: ");
        int num = scan.nextInt();

        String repeat = stringSample.repeat(num);
        System.out.println("Repeating " + stringSample + " " + num + " times: " + repeat);
    }
}
