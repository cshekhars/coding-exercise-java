package com.example.exercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
https://www.javatpoint.com/java-regex
https://www.w3schools.com/java/java_regex.asp
 */
public class RegularExpression {
    public static void main(String... args){
        System.out.println(String.format("Input: %s, Pattern: %s, Match: %s",
                "as", ".s", Pattern.matches(".s", "as")));      //True
        System.out.println(String.format("Input: %s, Pattern: %s, Match: %s",
                "ass", ".s", Pattern.matches(".s", "ass")));    //false
        System.out.println(String.format("Input: %s, Pattern: %s, Match: %s",
                "mst", ".s", Pattern.matches(".s", "mst")));    //False
        System.out.println(String.format("Input: %s, Pattern: %s, Match: %s",
                "mas", "..s", Pattern.matches("..s", "mas")));    //true

        //	[abc] - a, b, or c (simple class)
        System.out.println(String.format("Input: %s, Pattern: %s, Match: %s",
                "b", "[abc]", Pattern.matches("[abc]", "b")));    //true
        //First letter among a, b, c then any number of letters from a - z
        // . is any letter and * means 0 or more
        // + is one or more
        // ? is zero or one
        System.out.println(String.format("Input: %s, Pattern: %s, Match: %s",
                "asstd", "[abc][a-z]*", Pattern.matches("[abc][a-z]*", "asstd")));    //true

        System.out.println(String.format("Input: %s, Pattern: %s, Match: %s",
                "z2asstd", ".*[abc].*", Pattern.matches(".*[abc].*", "z2asstd")));    //true

        //.* is any letter anytime
        System.out.println(String.format("Input: %s, Pattern: %s, Match: %s",
                "correction", ".*[ab].*", Pattern.matches(".*[ab].*", "correction")));    //false

        //How to extract a substring using regex ?
        //   Example - String test = "This is a test String and 'This is data we want'"
        String data = "This is a test String and 'This is data we want'";
        Matcher matcher = Pattern.compile("'(.*)'").matcher(data);
        if(matcher.find()){
            System.out.println(matcher.group(1));
        }
         matcher = Pattern.compile("'.*'").matcher(data);
        if(matcher.find()){
            System.out.println(matcher.group(0));
        }

    }
}
