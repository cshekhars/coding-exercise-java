package com.example.exercise;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String... args){
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any number");
        number = scanner.nextInt();
        boolean isPrime = isPrime(number);
        System.out.println("isPrime: "+ isPrime);
    }

    private static boolean isPrime(int number){
        boolean isPrime = false;
        if(number <= 1){
            return false;
        }
        if(number == 2){
            return true;
        }
        for (int i = 2; i < number / 2 ; i++){
            if(number % i == 0){
                isPrime = true;
                break;
            }
        }
        return isPrime;
    }
}
