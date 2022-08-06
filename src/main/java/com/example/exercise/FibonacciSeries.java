package com.example.exercise;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = scanner.nextInt();
        int prev = 0;
        int next = 1;
        System.out.println(next);
        while(next<= number){
            System.out.println(next);
            int temp = next;
            next = next + prev;
            prev = temp;

        }
    }
}
