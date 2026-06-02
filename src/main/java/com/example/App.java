package com.example;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Main application class
 */
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to srkInterview Java Project!");
        BufferedWriter bufferedWriter = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        bufferedWriter.write("Longest substring without repeating characters in 'abcabcbb' = "
                + LongestSubstringExample.lengthOfLongestSubstring("abcabcbb"));
        bufferedWriter.flush();
    }
}

