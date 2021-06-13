package ru.gb.pugacheva.lesson8homework;

import java.util.LinkedList;

public class LinkHashTable <K,V> implements LinkedHashTable<K,V>{

    static class ItemL <K,V> implements Entry<K,V> {
        private final K key;
        private V value;

        public ItemL(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private final LinkedList<ItemL<K,V>>[] data;
    private int size;

    public LinkHashTable(int initialCapacity) {
        this.data = new LinkedList[initialCapacity]; // убрали удвоение емкости
    }

    private int hashFunc(K key){
        return key.hashCode() % data.length;
    }

    @Override
    public void put(K key, V value) {
        int index = hashFunc(key);
        if( data[index] == null){
            LinkedList <ItemL<K,V>> linkedList=new LinkedList<>();
            data [index]= linkedList;
        }
        int indexInList = containsKey(data[index],key);
        if(data[index].isEmpty() || indexInList == -1) {
            data[index].add(new ItemL<>(key, value));
        }else if( indexInList >=0) {
            data[index].get(indexInList).setValue(value);
        }
        size++;
    }

    private int containsKey (LinkedList <ItemL<K,V>> list, K key){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getKey().equals(key)){
                return hashFunc(key);
            }
        }
        return -1;
    }

    @Override
    public V get(K key) {
        int index = hashFunc(key);
        LinkedList<ItemL<K,V>> currentList = data[index];
        for (int i = 0; i < currentList.size(); i++) {
            if(currentList.get(i).getKey().equals(key)){
                V value = (V)currentList.get(i).getValue();
                return value;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hashFunc(key);
        LinkedList<ItemL<K,V>> currentList = data[index];
        for (int i = 0; i < currentList.size(); i++) {
            if(currentList.get(i).getKey().equals(key)){
                V value = (V)currentList.get(i).getValue();
                currentList.remove(i);
                size--;
                return value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size!=0;
    }

    @Override
    public void display() {
        System.out.println("-----------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i,data[i]);
        }
        System.out.println("-----------------");
    }
}
