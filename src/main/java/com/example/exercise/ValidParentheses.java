package com.example.exercise;

import java.util.Map;
import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Input: s = "()"
Output: true
Input: s = "(]"
Output: false
Input: s="{[]}"
Output: true
 */
public class ValidParentheses {
    public static void main(String... args){
        String s = "(({}[]){[]})";
        System.out.println(isValid2(s));
    }
    //4 ms 42.1 MB
    public static boolean isValid(String s) {
        if(s == null || s.length() < 2) return false;
        Map<Character, Character> map = Map.of('{', '}', '(', ')', '[', ']');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i=0; i< chars.length; i++){
            char c1 = chars[i];
            if(map.containsKey(c1)) stack.push(c1);
            else {
                if(stack.isEmpty()) return false;
                char c2 = stack.pop();
                if(c1 != map.get(c2)) return false;
            }
        }
        return stack.empty();
    }

    //2 ms 42.4 MB
    public static boolean isValid2(String s) {
        if(s == null || s.length() < 2) return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i=0; i< chars.length; i++){
            char c1 = chars[i];
            if(c1 == '(' || c1 == '{' || c1 == '[') stack.push(c1);
            else {
                if(stack.isEmpty()) return false;
                char c2 = stack.pop();
                if(c1 == ')' && c2 != '(') return false;
                if(c1 == '}' && c2 != '{') return false;
                if(c1 == ']' && c2 != '[') return false;
            }
        }
        return stack.empty();
    }
}
