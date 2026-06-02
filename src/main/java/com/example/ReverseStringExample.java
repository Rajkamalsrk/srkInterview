package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ReverseStringExample {
    public static void main(String[] args) {
        String original = "Hello, World!";
        String reversed = reverseString(original);
        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
        System.out.println("Reversed using char method: " + reverseStringChar(original));
        System.out.println(countChars(original));
        System.out.println(countWords(original));
    }

    public static String reverseString(String original) {
        if (original == null) {
            return null;
        }

        final StringBuilder buffer = new StringBuilder(original);
        buffer.reverse();
        return buffer.toString();
    }

    public static String reverseStringChar(String original) {
        if (original == null) {
            return null;
        }
        StringBuilder buffer = new StringBuilder();
        for(int  i = original.length() - 1; i >= 0; i--) {
            buffer.append(original.charAt(i));
        }
        return buffer.toString();
    }

    public static Map<Character, Integer> countChars(String original) {
        String cleaned = original.replaceAll("[^a-zA-Z0-9]", "");
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char ch : cleaned.toCharArray()) {
            charCountMap.putIfAbsent(ch, 1);
        }
        return charCountMap;
    }

    public static Map<String, Long> countWords(String original) {
        return Arrays.stream(original.split(" "))
                .flatMap(str -> Arrays.stream(str.split("[^a-zA-Z0-9]+")))
        .collect(Collectors.groupingBy(str -> str, Collectors.counting()));
    }
}
