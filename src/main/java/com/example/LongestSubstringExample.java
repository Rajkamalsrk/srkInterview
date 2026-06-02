package com.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Solution for finding the length of the longest substring without repeating characters.
 */
public class LongestSubstringExample {

    public static void main(String[] args) {
        String[] samples = {"abcabcbb", "bbbbb", "pwwkew", "", "dvdf", "abba"};

        System.out.println("Longest Substring Without Repeating Characters:");
        for (String sample : samples) {
            System.out.printf("Input: %-10s -> Length: %d%n", '"' + sample + '"', lengthOfLongestSubstringShort(sample));
        }
    }

    /**
     * Uses a sliding window to track the current substring of unique characters.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(min(n, alphabet size))
     *
     * @param str input string
     * @return length of the longest substring containing no repeated characters
     */
    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> lastSeenIndex = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < str.length(); right++) {
            char current = str.charAt(right);

            if (lastSeenIndex.containsKey(current) && lastSeenIndex.get(current) >= left) {
                left = lastSeenIndex.get(current) + 1;
            }

            lastSeenIndex.put(current, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstringShort(String s) {
        if (s == null || s.isEmpty()) return 0;
        Map<Character, Integer> seen = new LinkedHashMap<>();
        int left = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            left = Math.max(left, seen.getOrDefault(s.charAt(i), -1) + 1);
            seen.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}

