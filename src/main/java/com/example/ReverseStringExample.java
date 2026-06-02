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
        System.out.println(findFirstNonRepeatedCharacter("introduction"));
        System.out.println("'listen' and 'silent': " + areAnagrams("listen", "silent"));
        System.out.println("Reverse recursive: " + reverseRecursive(original));
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

    //Find the first non-repeated (unique) character in a given string.
    // If no such character exists, return a designated flag value (e.g., \\0).
    public static char findFirstNonRepeatedCharacter(String str) {
        if (str == null || str.isEmpty()) {
            return '\0';
        }

        // Count the frequency of each character
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char ch : str.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }

        System.out.println("Character frequencies: " + charFrequency);

        // Find the first character with frequency 1
        for (char ch : str.toCharArray()) {
            if (charFrequency.get(ch) == 1) {
                return ch;
            }
        }

        // No non-repeated character found
        return '\0';
    }


    public static boolean areAnagrams(String first, String second) {
        if(first == null || second == null || first.length() != second.length()) {
            return false;
        }

        final String cleanedFirst = first.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        final String cleanedSecond = second.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        final char[] c1 = cleanedSecond.toCharArray();
        final char[] c2 = cleanedFirst.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    public static String reverseRecursive(String str) {
        String cleaned = str.replaceAll("[^a-zA-Z0-9\\s]", "");
        // str.replaceAll("[^a-zA-Z0-9\\s]", "")
        if (cleaned.isEmpty()) {
            return str;
        }

        return reverseString(cleaned.substring(1)) + cleaned.charAt(0);
    }
}
