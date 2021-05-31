package ru.gb.pugacheva.lesson4;

public interface LinkedList <E>{

    void insertFirst (E value);

    E removeFirst ();

    boolean remove (E value);

    boolean contains (E value);

    int size();

    boolean isEmpty ();

    void  display ();

    E getFirst ();

    class Node <E>{
        E item;
        Node <E> next;
        Node <E> previous;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }

        public Node(E item, Node<E> next, Node<E> previous) {  //второй вариант конструктора
            this.item = item;
            this.next = next;
            this.previous=previous;
        }
    }

}
