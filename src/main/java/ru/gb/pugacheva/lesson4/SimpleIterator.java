package ru.gb.pugacheva.lesson4;

import java.util.Iterator;

public class SimpleIterator <E> implements Iterator <E> {

    private SimpleLinkedListImpl <E> list;
    private LinkedList.Node <E> current;

    public SimpleIterator(SimpleLinkedListImpl<E> list) {
        this.list = list;
        this.current = list.firstElement;
    }

    @Override
    public boolean hasNext() {
        return current!=null;
    }

    @Override
    public E next() {
        if (hasNext()) {
            E item = current.item;
            current=current.next;
            return item;
        }
        return  null;
    }

}
