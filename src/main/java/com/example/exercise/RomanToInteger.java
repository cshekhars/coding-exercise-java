package com.example.exercise;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String... args){
        String roman = "IVX";
        int integer = romanToInt(roman);
        System.out.println(integer);
    }

    private static int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50,
                'C', 100, 'D', 500, 'M', 1000);
        char[] chars = s.toCharArray();
        int result = 0;
        int rightCharValue = 0;
        for(int i = chars.length - 1; i>=0; i--){
            int currentCharValue = map.get(chars[i]);
            if(i == chars.length || rightCharValue <= currentCharValue){
                result = result + currentCharValue;
            } else {
                result = result - currentCharValue;
            }
            rightCharValue = currentCharValue;
        }
        return result;
    }

    private static int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int rightCharValue = 0;
        int length = s.length();
        for(int i = length - 1; i>=0; i--){
            int currentCharValue = map.get(s.charAt(i));
            if(i == length || rightCharValue <= currentCharValue){
                result = result + currentCharValue;
            } else {
                result = result - currentCharValue;
            }
            rightCharValue = currentCharValue;
        }
        return result;
    }
}
