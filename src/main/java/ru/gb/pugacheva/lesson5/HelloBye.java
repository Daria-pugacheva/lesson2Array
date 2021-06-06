package ru.gb.pugacheva.lesson5;

public class HelloBye {

    public static void main(String[] args) {
        hello("Bob");

    }

    private static void hello (String name){
        print ("Hello, "+ name + "!");
        bye (name);
    }

    private static void bye (String name){
        print ("Good bye, " + name + "!");
    }

    private static void print (String string){
        System.out.println(string);
    }
}
