package ru.innopolis.java.test.Lesson1.Task2;

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random rand = new Random(); // добавляем объект Random
        int playerOneNum = rand.nextInt(3); // инициализируем первого игрока - Вася
        int playerTwoNum = rand.nextInt(3); // инициализируем второго игрока - Петя

        System.out.println(playerOneNum);
        System.out.println(playerTwoNum);

        /*
            камень = 0;
            ножницы = 1;
            бумага = 2;
        */

        if (playerOneNum == 0) {
            if (playerTwoNum == 1) {
                System.out.println("Вася - камень, Петя - ножницы");
                System.out.println("Выиграл Вася");
            } else if (playerTwoNum == 2) {
                System.out.println("Вася - камень, Петя - бумага");
                System.out.println("Выиграл Петя");
            } else {
                System.out.println("Ничья");
            }
        }
        if (playerOneNum == 1) {
            if (playerTwoNum == 0) {
                System.out.println("Вася - ножницы, Петя - Камень");
                System.out.println("Выиграл Вася");
            } else if (playerTwoNum == 2) {
                System.out.println("Вася - ножницы, Петя - бумага");
                System.out.println("Выиграл Петя");
            } else {
                System.out.println("Ничья");
            }
        }
        if (playerOneNum == 2) {
            if (playerTwoNum == 1) {
                System.out.println("Вася - бумага, Петя - ножницы");
                System.out.println("Выиграл Петя");
            } else if (playerTwoNum == 0) {
                System.out.println("Вася - бумага, Петя - камень");
                System.out.println("Выиграл Петя");
            } else {
                System.out.println("Ничья");
            }
        }
    }
}