package ru.gb.pugacheva.lesson3.queue;

public interface MyDequeue<E> {

    boolean insertLeft (E value);
    boolean insertRight (E value);

    E removeLeft ();
    E removeRight ();

    E peekFront();
    E peekTail();

    int size();

    boolean isEmpty();

    boolean isFull();


}
