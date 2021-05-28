package ru.gb.pugacheva.lesson3;

import ru.gb.pugacheva.lesson3.queue.PriorityQueue;
import ru.gb.pugacheva.lesson3.queue.Queue;
import ru.gb.pugacheva.lesson3.queue.QueueImpl;
import ru.gb.pugacheva.lesson3.stack.Stack;
import ru.gb.pugacheva.lesson3.stack.StackImpl;

public class Testing {


    public static void main(String[] args) {
       testStack();
       testDueue();
       testPriorotyDueue();

    }

    private static void testPriorotyDueue() {
        Queue <Integer> queue = new PriorityQueue<>(5);
        System.out.println(queue.insert(3));
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(2));
        System.out.println(queue.insert(6));
        System.out.println(queue.insert(4));

        System.out.println("peek " + queue.peekFront());
        System.out.println("size " + queue.size());
        System.out.println("is full " + queue.isFull());

        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }


    }

    private static void testDueue() {
        Queue <Integer> queue = new QueueImpl<>(5);
        System.out.println(queue.insert(3));
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(2));
        System.out.println(queue.insert(6));
        System.out.println(queue.insert(4));


        System.out.println("peek " + queue.peekFront());
        System.out.println("size " + queue.size());
        System.out.println("is full " + queue.isFull());

        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }


    }

    private static void testStack() {
        Stack<Integer> stack = new StackImpl<>(5);
        System.out.println("add 1" + addToStack(stack,1));
        System.out.println("add 2" + addToStack(stack,2));
        System.out.println("add 3" + addToStack(stack,3));
        System.out.println("add 4" + addToStack(stack,4));
        System.out.println("add 5" + addToStack(stack,5));
        System.out.println("add 6" + addToStack(stack,6));

        stack.display();

        System.out.println("size " + stack.size());
        System.out.println("remove " + removeFromStack(stack));

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private static Integer removeFromStack(Stack<Integer> stack) {
        return !stack.isEmpty() ? stack.pop() : null;
    }

    private static boolean addToStack(Stack<Integer> stack, Integer value) {
        if (!stack.isFull()) {
            stack.push(value);
            return true;
        }
        return false;
    }






}
