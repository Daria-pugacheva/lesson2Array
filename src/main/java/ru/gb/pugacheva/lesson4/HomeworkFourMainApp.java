package ru.gb.pugacheva.lesson4;

public class HomeworkFourMainApp {
    public static void main(String[] args) {

        // Проверка работоспособности итератора для простого связанного списка
        SimpleLinkedListImpl <Integer> list = new SimpleLinkedListImpl<>();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.display();

        for (Integer integer: list){
            System.out.println(integer);
        }

        //проверка работоспособнотсти класса TwoSideLinkedListForDekImpl

        TwoSideLinkedListForDekImpl <Integer> dekList = new TwoSideLinkedListForDekImpl<>();
        dekList.insertFirst(4);
        dekList.insertFirst(3);
        dekList.insertFirst(2);
        dekList.insertFirst(1);
        dekList.insertLast(10);
        dekList.insertLast(20);
        dekList.insertLast(30);
        dekList.insertLast(40);

        dekList.display();

        dekList.removeFirst();
        dekList.removeLast();
        dekList.remove(1); // ЗДЕСЬ ВСЕ РАБОТАЕТ,а в строке 59 кидает NullPointerException..

        dekList.display();

        // проверка работоспособности класса LinkedDekImpl

        LinkedDekImpl <Integer> linkedDek = new LinkedDekImpl<>();

        linkedDek.insertRight(1);
        linkedDek.insertRight(2);
        linkedDek.insertRight(3);
        linkedDek.insertRight(4);
        linkedDek.insertLeft(40);
        linkedDek.insertLeft(30);
        linkedDek.insertLeft(20);
        linkedDek.insertLeft(10);

        linkedDek.display();

        linkedDek.removeRight();
        linkedDek.removeLeft();

        linkedDek.display();

        linkedDek.removeValue(1); // ЗДЕСЬ НЕ РАБОТАЕТ, хотя код аналогичен тому, что срабатывает в строке 35..

        linkedDek.display();

    }
}
