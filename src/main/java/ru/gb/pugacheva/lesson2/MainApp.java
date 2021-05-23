package ru.gb.pugacheva.lesson2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainApp {
    public static void main(String[] args) {

        Random rn = new Random();

        DynamicArray<Integer> arrayForBubbleSort = new DynamicArray<>(10000);
        for (int i = 0; i < 10000; i++) {
            arrayForBubbleSort.add(rn.nextInt(10000));
        }

        DynamicArray<Integer> arrayForSelectSort = new DynamicArray<>(10000);
        for (int i = 0; i < 10000; i++) {
            arrayForSelectSort.add(arrayForBubbleSort.get(i));
        }

        DynamicArray<Integer> arrayForInsertSort = new DynamicArray<>(10000);
        for (int i = 0; i < 10000; i++) {
            arrayForInsertSort.add(arrayForBubbleSort.get(i));
        }

//        arrayForBubbleSort.display();
//        arrayForSelectSort.display();
//        arrayForInsertSort.display();

        long startSortBubble = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
        arrayForBubbleSort.sortBubble();
        long stopSortBubble = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());

        long startSortSelect = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
        arrayForSelectSort.sortSelect();
        long stopSortSelect = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());

        long startSortInsert = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
        arrayForInsertSort.sortInsert();
        long stopSortInsert = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());

        System.out.println("Время сортировки пузырьком = " + (stopSortBubble-startSortBubble) + " миллисекунд.");
        System.out.println("Время сортировки выборкой = " + (stopSortSelect-startSortSelect) + " миллисекунд.");
        System.out.println("Время сортировки вставкой = " + (stopSortInsert-startSortInsert) + " миллисекунд.");

//        arrayForBubbleSort.display();
//        arrayForSelectSort.display();
//        arrayForInsertSort.display();
    }
}
