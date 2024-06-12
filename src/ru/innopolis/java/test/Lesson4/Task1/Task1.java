package ru.innopolis.java.test.Lesson4.Task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        String chars = "qwertyuiopasdfghjklzxcvbnm";

        Scanner scan = new Scanner(System.in);
        String ch = scan.next();

        int index = chars.indexOf(ch);
        //System.out.println(index - 1); - это печатает индекс симвода в строке

        if (ch.equals("q")) { // замкнуть клавиатуру получилось только так
            System.out.println('m');
        } else {
            char result = chars.charAt(index - 1);
            System.out.println(result);
        }
    }
}
