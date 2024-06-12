package ru.innopolis.java.test.Lesson4.Task3;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sampleString = scanner.nextLine();

        // строку разбил на две подстроки, каждую отдельно отсортировал через массив, потом перевёл обратно в строку и вывел на печать
        String substring1 = sampleString.split(" ")[0];
        String substring2 = sampleString.split(" ")[1];

        char[] tempCharArray = substring1.toCharArray();
        Arrays.sort(tempCharArray);
        char[] tempCharArray2 = substring2.toCharArray();
        Arrays.sort(tempCharArray2);

        System.out.println(new String(tempCharArray) + " " + new String(tempCharArray2));
    }
}
