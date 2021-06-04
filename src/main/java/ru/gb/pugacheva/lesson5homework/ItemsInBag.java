package ru.gb.pugacheva.lesson5homework;

public class ItemsInBag implements Comparable <ItemsInBag>{


    private String name;
    private int price;
    private int weight;

    public ItemsInBag(String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return (name + "(" + price + "руб., " + weight +
                " кг)");
    }

    @Override
    public int compareTo(ItemsInBag o) {
        return 0;
    }
}
