package ru.gb.pugacheva.lesson3.queue;

public interface Deque <E> extends Queue <E>{

    boolean insertLeft(E value);
    boolean insertRight (E value);

    E removeLeft();
    E removeRight();
}
