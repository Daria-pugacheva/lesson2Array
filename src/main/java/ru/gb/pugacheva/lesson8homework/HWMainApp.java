package ru.gb.pugacheva.lesson8homework;

public class HWMainApp {

    public static void main(String[] args) {

        LinkedHashTable <Products, Integer> hashTable = new LinkHashTable<>(5);

        hashTable.put(new Products(1, "Orange"),150);
        hashTable.put(new Products(72, "Banana"),100);
        hashTable.put(new Products(63, "Carrot"),228);
        hashTable.put(new Products(60, "Lemon"),250);
        hashTable.put(new Products(53, "Milk"),120);
        hashTable.put(new Products(25, "Potato"),67);

        System.out.println("Size is = " + hashTable.size());
        hashTable.display();

        System.out.println("Cost of potato is " + hashTable.get(new Products(25,"Potato")));
        System.out.println("Cost of banana is " + hashTable.get(new Products(72,"Banana")));
        System.out.println("Cost of carrot is " + hashTable.get(new Products(63,"Carrot")));

        hashTable.remove(new Products(25, "Potato"));
        hashTable.remove(new Products(72, "Banana"));

        System.out.println("Cost of potato is " + hashTable.get(new Products(25,"Potato")));
        System.out.println("Cost of banana is " + hashTable.get(new Products(72,"Banana")));
        System.out.println("Cost of carrot is " + hashTable.get(new Products(63,"Carrot")));

        hashTable.put(new Products(47, "Pineapple"),228);

        System.out.println("Size is = " + hashTable.size());
        hashTable.display();

    }


}
