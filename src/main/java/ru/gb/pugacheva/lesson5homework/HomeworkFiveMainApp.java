package ru.gb.pugacheva.lesson5homework;

import java.util.ArrayList;

public class HomeworkFiveMainApp {


    public static void main(String[] args) {

        //задание 1. проверка работоспособности метода возведения в степень
       System.out.println(exponent(2,4));

        //Задание 2. Проверка работоспособности задачи о рюкзаке

        ItemsInBag book = new ItemsInBag("Книга", 600, 1);
        ItemsInBag binoc = new ItemsInBag("Бинокль", 5000, 2);
        ItemsInBag medic = new ItemsInBag("Аптечка", 1500, 4);
        ItemsInBag nout = new ItemsInBag("Ноутбук", 40000, 2);
        ItemsInBag bowl = new ItemsInBag("Котелок", 500, 1);

        ArrayList<ItemsInBag> startItemsArr = new ArrayList<>();
        startItemsArr.add(book);
        startItemsArr.add(binoc);
        startItemsArr.add(medic);
        startItemsArr.add(nout);
        startItemsArr.add(bowl);

        System.out.println("Стартовый набор вещей: " +  startItemsArr);

        Bag<ItemsInBag> bestBag = new Bag<> (4, startItemsArr);

        System.out.println (bestBag);


    }

    // Задание 1. Метод возведения в степень с применением рекурсии.
    private static int exponent(int number, int pow) {
        if (pow <= 1) {
            return number;
        }
        return number * exponent(number, pow - 1);
    }


}
