package ru.gb.pugacheva.lesson5;

public class Factorial {

    public static void main(String[] args) {
       // System.out.println(factorial(5));
        System.out.println(tailFactorial(5));

    }

    private static int factorial (int n){
        if(n<=1){
            return 1;
        }
        return n*factorial(n-1);
    }

    private static int tailFactorial(int n){
        return fact(1,n);
    }

    private static int fact(int acc, int n){
        if(n<=0){
            throw new IllegalArgumentException("n should be > 0 ");
        }
        if (n==0 || n==1){
            return acc;
        }
        return fact(acc*n, n-1);
    }
}
