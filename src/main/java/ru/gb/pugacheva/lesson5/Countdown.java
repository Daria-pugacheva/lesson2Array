package ru.gb.pugacheva.lesson5;

public class Countdown {

    public static void main(String[] args) {
        //countDounLoop (5);
        countDounRecursion(5);

    }

    private static void countDounLoop (int n){
        while (n>0){
            System.out.println(n);
            n--;
        }
//        // 2-й вариант
//        while (true){
//            System.out.println(n);
//            n--;
//            if(n<=0){
//                break;
//            }
//        }
    }

    private static void countDounRecursion (int n){
        if (n<=0){
            return;
        }
        System.out.println(n);
        countDounRecursion(--n);
    }




}
