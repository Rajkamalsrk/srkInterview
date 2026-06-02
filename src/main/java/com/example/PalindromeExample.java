package com.example;

public class PalindromeExample {
    public static void main(String[] args) {
        System.out.println(isPalindrome("AMMA"));
    }

    public static boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversedStr = new StringBuilder(cleanStr).reverse().toString();
        return cleanStr.equals(reversedStr);
    }
}
