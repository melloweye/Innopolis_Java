package ru.innopolis.java.test.homework04.Task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        String chars = "qwertyuiopasdfghjklzxcvbnm";

        Scanner scan = new Scanner(System.in);
        String ch = scan.next();

        int index = chars.indexOf(ch);

        if (ch.equals("q")) { // замкнуть клавиатуру получилось только так
            System.out.println('m');
        } else {
            char result = chars.charAt(index - 1);
            System.out.println(result);
        }
    }
}
