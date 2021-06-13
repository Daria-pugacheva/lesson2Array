package ru.gb.pugacheva.lesson8homework;

public interface LinkedHashTable <K,V> {


    void put (K key, V value);

    V get (K key);

    V remove (K key);

    int size ();

    boolean isEmpty ();

    void display ();

    interface Entry <K,V>{
        K getKey();
        V getValue();
        void setValue (V value);
    }
}
