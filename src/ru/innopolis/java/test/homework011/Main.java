package ru.innopolis.java.test.homework011;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Automobile> cars = new ArrayList<>();
        cars.add(new Automobile("a123me", "Mercedes", "White", 0, 8300000));
        cars.add(new Automobile("b873of", "Volga", "Black", 0, 673000));
        cars.add(new Automobile("w487mn", "Lexus", "Grey", 76000, 900000));
        cars.add(new Automobile("p987hj", "Volga", "Red", 610, 704340));
        cars.add(new Automobile("c987ss","Toyota","White",254000,761000));
        cars.add(new Automobile("o983op","Toyota","Black",698000,740000));
        cars.add(new Automobile("p146op","BMW","White",271000,850000));
        cars.add(new Automobile("u893ii","Toyota","Purple",210900,440000));
        cars.add(new Automobile("l097df","Toyota","Black",108000,780000));
        cars.add(new Automobile("y876wd","Toyota","Black",160000,1000000));


        String colorToFind = "Black";
        long mileageToFind = 0L;
        long priceRangeStart = 700_000L;
        long priceRangeEnd = 800_000L;
        String modelToFind = "Toyota";

        // это задание №1: Номера всех автомобилей, имеющих заданный в переменной colorToFind цвет или нулевой пробег mileageToFind
        var matchedCars1 = cars.stream()
                .filter(car -> car.getCarColor().equals(colorToFind) || car.getCarMileage() == mileageToFind)
                .map(Automobile::getCarNumber)
                .collect(Collectors.toList());
        System.out.println("Номера автомобилей, имеющих заданный цвет или нулевой пробег: " + matchedCars1);

        // это задание №2: Количество уникальных моделей в ценовом диапазоне от n до m тыс
        var matchedCars2 = cars.stream()
                .filter(car -> car.getCarPrice() >= priceRangeStart && car.getCarPrice() <= priceRangeEnd)
                .map(Automobile::getCarModel)
                .distinct()
                .count();
        System.out.println("Количество уникальных моделей в заданном ценовом диапазоне: " + matchedCars2 + " шт.");

        // это задание №3: Вывести цвет автомобиля с минимальной стоимостью
        var matchedCars3 = cars.stream()
                .min(Comparator.comparing(Automobile::getCarPrice))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Цвет авто с самой низкой ценой: " + matchedCars3.getCarColor());

        // это задание №4: Средняя стоимость искомой модели modelToFind
        var matchedCars4 = cars.stream()
                .filter(car -> car.getCarModel().equals(modelToFind)) // В данном случае это Тойота
                .map(Automobile::getCarPrice)
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
        System.out.printf("Среднее из пробегов марки %s: %.2f", modelToFind, matchedCars4);
    }
}
