package com.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

    /**
     * Solution for the String Segmentation / Word Break problem.
     * Given a string and a dictionary of words, determine if the string can be
     * segmented into a space-separated sequence of one or more dictionary words.
     */
public class WordBreakExample {

    public static void main(String[] args) {
        List<String> dict1 = Arrays.asList("leet", "code");
        List<String> dict2 = Arrays.asList("apple", "pen");
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");

        System.out.println("Word Break examples:");
        System.out.println("leetcode -> " + wordBreak("leetcode", dict1));
        System.out.println("applepenapple -> " + wordBreak("applepenapple", dict2));
        System.out.println("catsandog -> " + wordBreak("catsandog", dict3));
    }

    /**
     * Dynamic programming solution.
     * Time Complexity: O(n^2) in the worst case
     * Space Complexity: O(n)
     * @param s the input string
     * @param wordDict dictionary of allowed words
     * @return true if the string can be segmented using dictionary words
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        if (wordDict == null || wordDict.isEmpty()) {
            return false;
        }

        Set<String> dictionary = new HashSet<>(wordDict);
        int maxWordLength = 0;
        for (String word : dictionary) {
            if (word != null) {
                maxWordLength = Math.max(maxWordLength, word.length());
            }
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int end = 1; end <= s.length(); end++) {
            int startLimit = Math.max(0, end - maxWordLength);
            for (int start = end - 1; start >= startLimit; start--) {
                if (!dp[start]) {
                    continue;
                }
                if (dictionary.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}

