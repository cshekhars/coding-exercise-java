package com.example.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringDuplicateCharacters {
    public static void main(String...strings) {
        String str = "programmming";
//        printDuplicateCharacters(str);
        printDuplicateCharacters2(str);
    }

    private static void printDuplicateCharacters(String str){
        char[] chars = str.toCharArray();
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i< chars.length ; i++){
            frequencyMap.compute(chars[i], (k, v) -> v == null ? 1 : ++v);
        }
        frequencyMap.entrySet().forEach(entry -> {
            if(entry.getValue() > 1){
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        });
    }

    private static void printDuplicateCharacters2(String str){
        Set<Character> set = new HashSet<>();
        for(int i=0 ; i<str.length() ; i++){
            if(!set.add(str.charAt(i))){
                System.out.println(str.charAt(i));
            }
        }
    }
}
