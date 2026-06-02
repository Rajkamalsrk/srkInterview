package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the application
 */
public class AppTest {
    
    @Test
    public void testAppExists() {
        assertNotNull(new App());
    }

    // Test cases for findFirstNonRepeatedCharacter
    @Test
    public void testFirstNonRepeatedCharacterSimple() {
        // "introduction" - first non-repeated is 'i'
        char result = ReverseStringExample.findFirstNonRepeatedCharacter("introduction");
        assertEquals('i', result);
    }

    @Test
    public void testFirstNonRepeatedCharacterAllRepeated() {
        // "aabbcc" - all characters are repeated
        char result = ReverseStringExample.findFirstNonRepeatedCharacter("aabbcc");
        assertEquals('\0', result);
    }

    @Test
    public void testFirstNonRepeatedCharacterEmpty() {
        // Empty string should return null character
        char result = ReverseStringExample.findFirstNonRepeatedCharacter("");
        assertEquals('\0', result);
    }

    @Test
    public void testFirstNonRepeatedCharacterNull() {
        // Null string should return null character
        char result = ReverseStringExample.findFirstNonRepeatedCharacter(null);
        assertEquals('\0', result);
    }

    @Test
    public void testFirstNonRepeatedCharacterSingleChar() {
        // Single character is always unique
        char result = ReverseStringExample.findFirstNonRepeatedCharacter("a");
        assertEquals('a', result);
    }

    @Test
    public void testFirstNonRepeatedCharacterMultipleUnique() {
        // "abcdefg" - first character 'a' is non-repeated
        char result = ReverseStringExample.findFirstNonRepeatedCharacter("abcdefg");
        assertEquals('a', result);
    }

    @Test
    public void testFirstNonRepeatedCharacterWithSpecialChars() {
        // "a@a#b$b%c" - first non-repeated is '@'
        char result = ReverseStringExample.findFirstNonRepeatedCharacter("a@a#b$b%c");
        assertEquals('@', result);
    }

    @Test
    public void testFirstNonRepeatedCharacterComplex() {
        // "abacabad" - first non-repeated is 'c'
        char result = ReverseStringExample.findFirstNonRepeatedCharacter("abacabad");
        assertEquals('c', result);
    }

    // Test cases for Anagram Checker
    @Test
    public void testAnagramsBasic() {
        // "listen" and "silent" are anagrams
        assertTrue(AnagramExample.areAnagrams("listen", "silent"));
    }

    @Test
    public void testAnagramsNotAnagrams() {
        // "hello" and "world" are not anagrams
        assertFalse(AnagramExample.areAnagrams("hello", "world"));
    }

    @Test
    public void testAnagramsIgnoreCase() {
        // Case insensitive - "Listen" and "SILENT" are anagrams
        assertTrue(AnagramExample.areAnagrams("Listen", "SILENT"));
    }

    @Test
    public void testAnagramsWithSpaces() {
        // Spaces should be ignored - "Dormitory" and "Dirty room" are anagrams
        assertTrue(AnagramExample.areAnagrams("Dormitory", "Dirty room"));
    }

    @Test
    public void testAnagramsSingleCharacter() {
        // Single character anagrams
        assertTrue(AnagramExample.areAnagrams("a", "a"));
    }

    @Test
    public void testAnagramsEmptyStrings() {
        // Both empty strings are anagrams
        assertTrue(AnagramExample.areAnagrams("", ""));
    }

    @Test
    public void testAnagramsDifferentLengths() {
        // Different lengths - not anagrams
        assertFalse(AnagramExample.areAnagrams("abc", "abcd"));
    }

    @Test
    public void testAnagramsNullValues() {
        // Both null should be considered same
        assertTrue(AnagramExample.areAnagrams(null, null));
    }

    @Test
    public void testAnagramsOneNull() {
        // One null and one non-null are not anagrams
        assertFalse(AnagramExample.areAnagrams("test", null));
    }

    @Test
    public void testAnagramsSpecialCharacters() {
        // "a@b#c" and "c@a#b" are anagrams (ignoring @#)
        assertTrue(AnagramExample.areAnagrams("a@b#c", "c@a#b"));
    }

    @Test
    public void testAnagramsMultipleSpaces() {
        // Multiple spaces should be ignored
        assertTrue(AnagramExample.areAnagrams("a   b   c", "c b a"));
    }

    @Test
    public void testAnagramsComplex() {
        // "The eyes" and "They see" are anagrams (ignoring spaces and case)
        assertTrue(AnagramExample.areAnagrams("The eyes", "They see"));
    }

    // Test cases for alternative methods
    @Test
    public void testAnagramsUsingMapBasic() {
        assertTrue(AnagramExample.areAnagramsUsingMap("listen", "silent"));
    }

    @Test
    public void testAnagramsUsingMapNot() {
        assertFalse(AnagramExample.areAnagramsUsingMap("hello", "world"));
    }

    @Test
    public void testAnagramsUsingArrayBasic() {
        assertTrue(AnagramExample.areAnagramsUsingArray("listen", "silent"));
    }

    @Test
    public void testAnagramsUsingArrayWithSpaces() {
        assertTrue(AnagramExample.areAnagramsUsingArray("Dormitory", "Dirty room"));
    }
}

