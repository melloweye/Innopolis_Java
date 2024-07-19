package ru.innopolis.java.test.homework10.general;

public class Sequence {
    public static int[] filter(int[] array, ByCondition condition) {
        /*
            метод принимает массив и условие фильтрации.
            1. Сначала считаем количество элементов, удовлетворяющих условию.
            2. Создаем массив нужного размера, для этого передаем counter при инициализации массива.
            3. Снова проходимся по массиву, отбираем значения, которые соответствуют условию и заполняем ими новый массив.
        */

        // проходим по массиву и определяем, соответсвуют ли значения в нём условию и считаем их
        int counter = 0;
        for (int nums : array) {
            if (condition.isOk(nums)) {
                counter++;
            }
        }

        // заполняем новый созданный массив result[] значениями, которые соответствуют условию
        int[] result = new int[counter];
        int index = 0;
        for (int nums : array) {
            if (condition.isOk(nums)) {
                result[index++] = nums;
            }
        }
        return result; // возвращаем заполненный массив
    }
}
