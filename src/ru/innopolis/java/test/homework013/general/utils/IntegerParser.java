package ru.innopolis.java.test.homework013.general.utils;

public class IntegerParser {
/*
----------------- метод main для проверки работы методов внутри класса -----------------
    public static void main(String[] args) {
        int result = validateCount("anvk8934763lds");
        System.out.println(result);

        double resultDouble = validateNumber("helllo2sih.sf34rre");
        System.out.println(resultDouble);
    }

 */

    public static int parseCount(String input) {
        try {
            return Integer.parseInt(input.replaceAll("\\D", ""));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid input of integer: " + input);
        }
    }

    public static int validateCount(String input) {
        try {
            return parseCount(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid input of integer: " + input);
        }
    }

    public static double parseNumber(String input) {
        try {
            return Double.parseDouble(input.replaceAll("[\\s+a-zA-Z :]",""));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid input of double: " + input);
        }
    }

    public static double validateNumber(String input) {
        try {
            return parseNumber(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid input of double: " + input);
        }
    }
}

