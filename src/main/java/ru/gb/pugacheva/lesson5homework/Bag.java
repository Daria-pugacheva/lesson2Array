package ru.gb.pugacheva.lesson5homework;

import java.util.ArrayList;

public class Bag <E extends Comparable<? super ItemsInBag>> {
    private final int capacity;
    private int maxWeight = 0;
    private int maxPrice = 0;
    private ArrayList<ItemsInBag> things;
    private ArrayList<ItemsInBag> load = null;

    public Bag(int capacity, ArrayList<ItemsInBag> things) {
        this.capacity = capacity;
        this.things = things;
        variants(things, 0); //про создании рюкзака сразу его комплектуем идеально
        }

    // перебор вариантов загрузки
    public void variants(ArrayList<ItemsInBag> arrayList, int start) {
        if (arrayList == null || start >= arrayList.size()) {
            return;
        }
        int quantity = arrayList.size() - (start + 1);

        if (quantity == 0) { //если в исходном наборе вещей только одна вещь.

            loadBag(arrayList);

        } else if (quantity == 1) { //если вещей две, то меняем их местами и потом обратно

            loadBag(arrayList);
            arrayList.add(arrayList.remove(start));

            loadBag(arrayList);
            arrayList.add(arrayList.remove(start));
        } else while (quantity-- >= 0) {
                variants(arrayList, start + 1);
                arrayList.add(arrayList.remove(start));
            }
        }

    // вариант перестановки вещей в рюкзаке сравниваем с результатми предыдущих комплектаций.
    private void loadBag(ArrayList<ItemsInBag> setOfItems) {
        int curentLoad = 0;
        int currentPrice = 0;
        ArrayList<ItemsInBag> itemsInBag = new ArrayList<>();

        // кладем вещи в рюкзак в порядке их следования в списке до загрузки:
        for (int i = 0; i < setOfItems.size(); i++) {
            ItemsInBag t = setOfItems.get(i);
            int w = t.getWeight();

            if (curentLoad + w > capacity) {
                break;
            }
            currentPrice += t.getPrice();
            curentLoad += w;
            itemsInBag.add(t);
        }
        // сохраняем результат текущей попытки загрузки в рукзак:
        if (currentPrice > this.maxPrice) {
            this.maxPrice = currentPrice;
            this.maxWeight = curentLoad;
            this.load = itemsInBag;
        }
    }

    @Override
    public String toString() {
        return String.format("\nЛучшая комплектация рюкзака: %s\n\t(общий вес %d, общая стоимость %d)",
                ((load != null) ? load.toString() : "[]"),
                maxWeight, maxPrice);
    }

}



