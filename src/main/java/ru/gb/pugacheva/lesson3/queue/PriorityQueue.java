package ru.gb.pugacheva.lesson3.queue;

public class PriorityQueue <E extends Comparable<? super E>> implements Queue <E>{

    private final E [] data;
    private int size;

    @SuppressWarnings("unchecked")
    public PriorityQueue(int maxSize) {
        this.data = (E[]) new Comparable[maxSize];
    }

    @Override
    public boolean insert(E value) {
        if(isFull()) {
            return false;
        }
        int index;
        for (index = size-1; index >=0  ; index--) {
            if(value.compareTo(data[index])> 0){ //если значение больше, чем то, которое лежит под индексом, значит, оно МЕНЕЕ приоритетное (более приоритетные с меньшим значением)
                data[index+1]=data[index]; //сдвигаем текущий элемент вправо на одну позицию
            }else {
                break;
            }
        }
        data[index+1]=value;
        size++;
        return true;
    }

    @Override
    public E remove() {
        return isEmpty() ? null : data[--size];
    }

    @Override
    public E peekFront() {
        return data[size-1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size== data.length;
    }
}
