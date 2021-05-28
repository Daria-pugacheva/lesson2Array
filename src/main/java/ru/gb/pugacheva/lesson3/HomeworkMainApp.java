package ru.gb.pugacheva.lesson3;

import ru.gb.pugacheva.lesson3.queue.DequeueImpl;
import ru.gb.pugacheva.lesson3.queue.PriorityQueue;
import ru.gb.pugacheva.lesson3.queue.Queue;
import ru.gb.pugacheva.lesson3.queue.QueueImpl;
import ru.gb.pugacheva.lesson3.stack.Stack;
import ru.gb.pugacheva.lesson3.stack.StackImpl;

public class HomeworkMainApp {
    public static void main(String[] args) {
        //Задание 1. Реализовать рассмотренные структуры данных в консольных программах.

        //1.1. Смотрим стэк. Без методов вставки и удаления с проверкой возможности.
        System.out.println("About stack:");
        Stack<Integer> stack = new StackImpl<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.display();
        System.out.println("size " + stack.size());
        System.out.println("pop " + stack.pop());

        //1.2. Смотрим очередь.
        System.out.println("----------");
        System.out.println("About queue");

        Queue<Integer> queue = new QueueImpl<>(3);
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(3));
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(7));

        System.out.println("peek " + queue.peekFront());
        System.out.println("size " + queue.size());
        System.out.println("is empty " + queue.isEmpty());
        System.out.println("remove " + queue.remove());
        System.out.println("size " + queue.size());

        // 1.3. Смотрим приоритетную очередь.
        System.out.println("________________");
        System.out.println("About priorityQueue");

        Queue<Integer> priorityQueue = new PriorityQueue<>(4);
        System.out.println(priorityQueue.insert(8));
        System.out.println(priorityQueue.insert(5));
        System.out.println(priorityQueue.insert(8));
        System.out.println(priorityQueue.insert(4));
        System.out.println(priorityQueue.insert(2));

        System.out.println("peek " + priorityQueue.peekFront());
        System.out.println("size " + priorityQueue.size());
        System.out.println("is full " + priorityQueue.isFull());
        System.out.println("remove: " + priorityQueue.remove());
        System.out.println("size " + priorityQueue.size());

        // Задание2. Проверка работоспособности метода в main
        System.out.println("________________");
        System.out.println("About reverse method:");
        System.out.println(reverse("abcd"));

        // Задание3. Проверка работоспособности Dequeue
        System.out.println("________________");
        System.out.println("About Dequeue:");
        DequeueImpl <Integer> dequeue = new DequeueImpl<>(6);
        dequeue.insertRight(10);
        dequeue.insertRight(20);
        dequeue.insertRight(30);
        dequeue.insertLeft(3);
        dequeue.insertLeft(2);
        dequeue.insertLeft(1);
        dequeue.insertLeft(0);
        dequeue.display();
        System.out.println(dequeue.removeRight());
        dequeue.display();
        System.out.println(dequeue.removeLeft());
        dequeue.display();
    }

    //Задание 2. Создать программу, которая переворачивает вводимые строки (переворачивает справа налево)
    public static String reverse(String stringForReverse) {

        StackImpl<Character> baseOrderOfChars = new StackImpl<>(stringForReverse.length());
        for (int i = 0; i < stringForReverse.length(); i++) {
            baseOrderOfChars.push(stringForReverse.charAt(i));
        }

        StringBuilder newString = new StringBuilder();
        while (!baseOrderOfChars.isEmpty()) {
            newString.append(baseOrderOfChars.pop());
        }

        return newString.toString();
    }
}

