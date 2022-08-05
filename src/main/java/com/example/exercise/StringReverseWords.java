package com.example.exercise;

/**
 * Given an input string s, reverse the order of the words.
 */
public class StringReverseWords {

    public static void main(String... args){
        String input = "My Name 1s +  Chander Shekhar .";
        String output = reverseWords(input);
        System.out.println(output);
    }

    private static String reverseWords(String str){
        str= str.strip();
        String[] words = str.split("\\W+"); //Remove .
//        String[] words = str.split("\\s+");
        reverseArray(words);
        return String.join(" ", words);
    }

    private static void reverseArray(String[] array){
        int low = 0;
        int high = array.length - 1;
        while(low < high){
            String temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            low++;
            high--;
        }
    }
}
