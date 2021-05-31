package ru.gb.pugacheva.lesson4;

import ru.gb.pugacheva.lesson3.queue.Deque;

public class LinkedDekImpl <E> implements Deque <E> {

    private final TwoSideLinkedListForDekImpl<E> data;

    public LinkedDekImpl() {
        this.data = new TwoSideLinkedListForDekImpl<E>();
    }

    @Override
    public boolean insertLeft(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E removeLeft() {
        return data.removeFirst();
    }

    @Override
    public E removeRight() {
        return data.removeLast();
    }

    @Override
    public boolean insert(E value) {
        try {
            throw new RuntimeException("This method is not valid: use insertLeft() or insertRight()");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override // в деке изначально метод remove без аргументов, поэтому его не переопределяю
    public E remove() {
        try {
            throw new RuntimeException("This method is not valid: use removeLeft() or removeRight()");
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean removeValue (E value){  // добавлен по аналогии с методом связаного списка, но
        return data.remove(value);   // не работает...выдает NullPointerException...Не могу понять, где образуется
    }                                  //несуществующий объект....

        @Override
        public E peekFront () {
            return data.getFirst();
        }

        @Override
        public int size () {
            return data.size();
        }

        @Override
        public boolean isEmpty () {
            return data.isEmpty();
        }

        @Override
        public boolean isFull () {
            return false;
        }

        public  void display(){
        data.display();
        }
    }

