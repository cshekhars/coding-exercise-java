package com.example.exercise;

public class StringPalindrome {
    public static void main(String... args){
        String str = "repaper";
        String reverse = reverseString(str);
        System.out.println(str.equals(reverse));
    }
    private static String reverseString(String str){
        char[] chars = str.toCharArray();
        int low = 0;
        int high = chars.length - 1;

        while(low < high){
            char temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
        return new String(chars);
    }
}
