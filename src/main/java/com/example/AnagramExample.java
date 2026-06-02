package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution to check if two strings are anagrams.
 * An anagram is a word or phrase formed by rearranging the letters of another word or phrase,
 * typically using all the original letters exactly once.
 */
public class AnagramExample {

    public static void main(String[] args) {
        System.out.println("Testing Anagram Checker:");
        System.out.println("'listen' and 'silent': " + areAnagrams("listen", "silent"));
        System.out.println("'hello' and 'world': " + areAnagrams("hello", "world"));
        System.out.println("'Dormitory' and 'Dirty room': " + areAnagrams("Dormitory", "Dirty room"));
        System.out.println("'a' and 'a': " + areAnagrams("a", "a"));
        System.out.println("'' and '': " + areAnagrams("", ""));
    }

    /**
     * Method 1: Using sorting
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return str1 == str2; // Both null or neither null
        }

        // Normalize strings: remove spaces and convert to lowercase
        String cleaned1 = str1.replaceAll("\\s+", "").toLowerCase();
        String cleaned2 = str2.replaceAll("\\s+", "").toLowerCase();

        // Check if lengths are different
        if (cleaned1.length() != cleaned2.length()) {
            return false;
        }

        // Sort both strings and compare
        char[] arr1 = cleaned1.toCharArray();
        char[] arr2 = cleaned2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    /**
     * Method 2: Using character frequency map
     * Time Complexity: O(n)
     * Space Complexity: O(1) - At most 26 lowercase letters
     */
    public static boolean areAnagramsUsingMap(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return str1 == str2;
        }

        // Normalize strings: remove spaces and convert to lowercase
        String cleaned1 = str1.replaceAll("\\s+", "").toLowerCase();
        String cleaned2 = str2.replaceAll("\\s+", "").toLowerCase();

        // Check if lengths are different
        if (cleaned1.length() != cleaned2.length()) {
            return false;
        }

        // Count character frequencies in first string
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char ch : cleaned1.toCharArray()) {
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }

        // Decrement frequencies for characters in second string
        for (char ch : cleaned2.toCharArray()) {
            if (!charFrequency.containsKey(ch)) {
                return false; // Character doesn't exist in first string
            }
            int count = charFrequency.get(ch);
            if (count == 1) {
                charFrequency.remove(ch);
            } else {
                charFrequency.put(ch, count - 1);
            }
        }

        // If map is empty, all characters matched
        return charFrequency.isEmpty();
    }

    /**
     * Method 3: Using character frequency array (for ASCII characters)
     * Time Complexity: O(n)
     * Space Complexity: O(1) - Fixed array size of 256
     */
    public static boolean areAnagramsUsingArray(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return str1 == str2;
        }

        // Normalize strings: remove spaces and convert to lowercase
        String cleaned1 = str1.replaceAll("\\s+", "").toLowerCase();
        String cleaned2 = str2.replaceAll("\\s+", "").toLowerCase();

        // Check if lengths are different
        if (cleaned1.length() != cleaned2.length()) {
            return false;
        }

        // Use array to count character frequencies
        int[] charCount = new int[256]; // ASCII character count

        // Increment for characters in first string
        for (char ch : cleaned1.toCharArray()) {
            charCount[ch]++;
        }

        // Decrement for characters in second string
        for (char ch : cleaned2.toCharArray()) {
            charCount[ch]--;
        }

        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}

