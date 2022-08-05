package com.example.exercise;

import java.util.Arrays;

public class StringAnagrams {
    public static void main(String...strings) {
        boolean result = isAnagram2("secure", "rescue");
        System.out.println(result);
    }

    private static boolean isAnagram(String str1, String str2){
        char[] str1Chars = str1.toCharArray();
        char[] str2Chars = str2.toCharArray();
        Arrays.sort(str1Chars);
        Arrays.sort(str2Chars);
        return new String(str1Chars).equals(new String(str2Chars));
    }

    private static boolean isAnagram2(String word, String anagram){
        char[] str1Chars = word.toCharArray();
        char[] str2Chars = anagram.toCharArray();
        Arrays.sort(str1Chars);
        Arrays.sort(str2Chars);
        return Arrays.equals(str1Chars, str2Chars);
    }
}
