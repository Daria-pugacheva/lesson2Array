package ru.gb.pugacheva.lesson5homework;

import java.util.ArrayList;
import java.util.List;

public class HomeworkFiveMainApp {


    public static void main(String[] args) {

//        //задание 1. проверка работоспособности метода возведения в степень
//       System.out.println(exponent(2,4));
//        System.out.println(exponentation(2,4));
//
//        //Задание 2. Проверка работоспособности задачи о рюкзаке. Мой вариант
//
//        ItemsInBag book = new ItemsInBag("Книга", 600, 1);
//        ItemsInBag binoc = new ItemsInBag("Бинокль", 5000, 2);
//        ItemsInBag medic = new ItemsInBag("Аптечка", 1500, 4);
//        ItemsInBag nout = new ItemsInBag("Ноутбук", 40000, 2);
//        ItemsInBag bowl = new ItemsInBag("Котелок", 500, 1);
//
//        ArrayList<ItemsInBag> startItemsArr = new ArrayList<>();
//        startItemsArr.add(book);
//        startItemsArr.add(binoc);
//        startItemsArr.add(medic);
//        startItemsArr.add(nout);
//        startItemsArr.add(bowl);
//
//        System.out.println("Стартовый набор вещей: " +  startItemsArr);
//
//        Bag<ItemsInBag> bestBag = new Bag<> (4, startItemsArr);
//
//        System.out.println (bestBag);

        //Проверка работоспособности задачи о рюкзаке. Вариант с урока
        List <Item> items = new ArrayList<>();
        items.add( new Item("Книга", 1, 600));
        items.add( new Item("Бинокль", 2, 5000));
        items.add( new Item("Аптечка", 4, 1500));
        items.add( new Item("Ноутбук", 2, 40000));
        items.add( new Item("Котелок", 1, 500));

        BackPack backPack = new BackPack(5);

        backPack.calcBestSet(items);

        for(Item item: backPack.getBestSet()){
            System.out.println(item.getName() + " " + item.getPrice());
        }

        System.out.println("Total best price is " + backPack.getBestPrice());



    }

    // Задание 1. Метод возведения в степень с применением рекурсии. Мой вариант
    private static int exponent(int number, int pow) {
        if (pow <= 1) {
            return number;
        }
        return number * exponent(number, pow - 1);
    }

    // Метод возведения в степень расширенный вариант (со степенью ноль и отрицательной)
    private static double exponentation (double digit, int rank){
        if(digit==0){
            if(rank>0){
                return 0;
            }else {
                throw new IllegalArgumentException("Invalid rank " + rank + " for digit=0");
            }
        }
        if(rank<0){
            return 1/digit*exponentation(digit,-rank-1);
        }else if(rank>0){
            return digit*exponentation(digit,rank-1);
        }else {
            return 1;
        }
    }


}
