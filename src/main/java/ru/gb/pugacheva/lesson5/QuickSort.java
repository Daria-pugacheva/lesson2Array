package ru.gb.pugacheva.lesson5;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int [] array, int low,int high) {
        if (array.length == 0) {
            return; // если длинна массива равна нулю ,то завершить выполнение
        }

        if (low >= high) {
            return; //завершить, если уже нечего разделять (границы сошлись)
        }

        //выбор опорного элемента
        int middle = low + (high - low) / 2;
        int pivot = array[middle];

        //разделение на подмассивы, которые больше и меньше опорного элемента

        int i = low;
        int j = high;

        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        //вызов рекурсии для сортировки левой и правой части
        if (low<j){
            quickSort(array,low,j);
        }

        if (high>i){
            quickSort(array,i,high);
        }
    }

    public static void main(String[] args) {
        int [] arr = {8,0,4,7,3,7,10,12,-3};
        System.out.println("Было");
        System.out.println(Arrays.toString(arr));

        int low = 0;
        int high = arr.length-1;

        quickSort(arr,low,high);
        System.out.println("Стало");
        System.out.println(Arrays.toString(arr));
    }
}
