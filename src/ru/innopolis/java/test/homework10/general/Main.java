package ru.innopolis.java.test.homework10.general;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 123, 231, 24 };

        // проверка на четность элементов массива
        ByCondition isEven = number -> number % 2 == 0;
        int[] evenNums = Sequence.filter(array, isEven);
        System.out.println(Arrays.toString(evenNums));

        // проверка на четность суммы каждого элемента массива
        ByCondition isSumEven = number -> {
            int sum = 0;
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum % 2 == 0;
        };
        int[] sumEvenNums = Sequence.filter(array, isSumEven);
        System.out.println(Arrays.toString(sumEvenNums));
    }
}
