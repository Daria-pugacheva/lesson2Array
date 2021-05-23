package ru.gb.pugacheva.lesson2;

import java.util.Arrays;

public class DynamicArray<E extends Comparable<? super E>> {

    private static final int DEFAULT_CAPACITY = 8;

    protected E[] data;
    protected int size;

    @SuppressWarnings("unchecked")
    public DynamicArray(int initialCapacity) {
        this.data = (E[]) new Comparable[initialCapacity];
    }

    public DynamicArray() {
        this(DEFAULT_CAPACITY); //вызов базового контруктора, в который мы передаем параметр initialCapacity=DEFAULT_CAPACITY (смотреть)
    }

    public void add(E value) {
        checkAndGrow();
        //data[size]=value; эти две строки опримизировали в одну ниже
        //size++;
        data[size++] = value; //ВОПРОС ПО КОДУ метода checkAndGrow:
        // здесь data.length станет равна size, как только мы добавим элемент на позицию 7 и инкрементируем
        // size. Т.е. увеличение размера массива будет производиться в блоке проверки, когда мы хотим добавить
        // элемент на 8-ю (последнюю в изачальном массиве) позицию, а не на позицию за его пределами. ТАК ВЕДЬ?
    }

    protected void checkAndGrow() {
        if (data.length == size) {
            data = Arrays.copyOf(data, сalculateNewLength());
        }
    }

    private int сalculateNewLength() {
        return size == 0 ? 1 : size * 2; //если size равен 0, то вернем 1, а в ином случае вернем удвоенный size (смотреть синтаксис)
    }

    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Incorrect 'index': %d; max value: %d",
                    index, size - 1));
        }
    }

    public boolean remove(E value) {
        int index = indexOf(value);
        //return index==-1 ? false : remove(index) != null; - ниже упростили
        return index != -1 && remove(index) != null;
    }

    public E remove(int index) {
        checkIndex(index);
        E removedValue = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        //data[size-1]=null; эти две строки оптимизировали в одну выше.
        //size--;
        return removedValue;
    }

    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    public int size() {  // привыкла в геттере писать getSize (смотреть доп.инфо)
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        //return super.toString(); реализация toString при выборе переопределения метода через Alt+Ins
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size - 1; i++) {
            sb.append(data[i]);
            sb.append(", ");
        }
        if (size > 0) {
            sb.append(data[size - 1]);
        }
        sb.append(" ]");
        return sb.toString();
    }

}
