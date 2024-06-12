package ru.innopolis.java.test.Lesson4.Task2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String find = ">>-->";
        String find2 = "<--<<";
        int lastIndex = 0;
        int counter = 0;
        // отдельно сделал подстроки, проверил вхождение каждой  из них и объединил общим счетчиком
        while ((lastIndex = input.indexOf(find, lastIndex)) != -1) {
            counter++;
            lastIndex += find.length();
        }
        while ((lastIndex = input.indexOf(find2, lastIndex)) != -1) {
            counter++;
            lastIndex += find2.length();
        }
        System.out.println(counter);
    }
}

/*
>>-->-><<<><><>>--><--<<>>-->>><><--<<--<<>>>>----->>--><<---<<--<<<-<<>>-->>-->
*/