package com.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWorkExample {
    public static void main(String[] args) {

        final String regex = "(\\w+)(\\s+\\1)+"; // duplicate word regex
        final Pattern pattern = Pattern.compile(regex,  Pattern.CASE_INSENSITIVE);

        final Scanner sc = new Scanner("I love Love to To tO code");
        String input = sc.nextLine();
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            input = input.replaceAll(matcher.group(), matcher.group(1)); // replace duplicate with single occurrence
        }

        System.out.println(input);
        sc.close();
    }
}
