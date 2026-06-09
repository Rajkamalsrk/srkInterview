package com.example;

public class FibonacciIterative {
    public static void main(String[] args) {
        int terms = 10; // Number of terms to display
        printFibonacci(terms);
    }

    public static void printFibonacci(int n) {
        int first = 0;
        int second = 1;
        System.out.print("Fibonacci Series (" + n + " terms): ");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        System.out.println();
    }
}
