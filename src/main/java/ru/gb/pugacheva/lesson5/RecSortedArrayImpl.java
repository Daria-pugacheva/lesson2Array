package ru.gb.pugacheva.lesson5;

import ru.gb.pugacheva.lesson2.SortedArray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RecSortedArrayImpl <E extends Comparable <? super E>> extends SortedArray <E> {

//    //старая реализация для сравнения
//
//    public int indexOf(E value) {
//        int low = 0;
//        int high = size - 1;
//
//        while (low <= high) {
//            int mid = (low + high) / 2;
//            if (data[mid].equals(value)) {
//                return mid;
//            } else if (value.compareTo(data[mid]) > 0) {
//                low = mid + 1;
//            } else {
//                high = mid - 1;
//            }
//        }
//        return -1;
//    }

    @Override
    public int indexOf(E value) {
        return recBinaryFind (value,0, size-1);
    }

    private int recBinaryFind(E value, int low, int high) {
        if (low>high){
            return -1;
        }
        int mid = (low + high) / 2;
        if (data[mid].equals(value)){
            return mid;
        }else if (value.compareTo(data[mid]) > 0) {
//            low = mid + 1;
//            recBinaryFind(value,low,high);
            return recBinaryFind(value,mid+1,high);
        } else {
//            high = mid - 1;
//            recBinaryFind(value,low,high);
            return recBinaryFind(value,low,mid-1);
        }
    }

    public static void main(String[] args) {
        RecSortedArrayImpl<Integer> data = new RecSortedArrayImpl<>();
        data.add(5);
        data.add(8);
        data.add(1);
        data.add(3);
        data.add(9);

        data.display();

        data.sortInsert();

        data.display();

        data.remove(0);

        data.remove(Integer.valueOf(3));

        data.display();

        System.out.println(data.contains(8));
        System.out.println(data.contains(10));
    }
}
