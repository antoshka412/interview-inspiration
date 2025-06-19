package org.problem.algorythm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubstringFrequencySorterTest {

    @Test
    void testMostFrequentSubstring() {
        String input = "abababc";
        int length = 2;
        String result = StringFrequencySorter.substringFrequencySorter(input, length);
        assertEquals("ab", result); // "ab" appears 3 times
    }

    @Test
    void testEqualFrequencySubstrings() {
        String input = "abcdabcd";
        int length = 2;
        String result = StringFrequencySorter.substringFrequencySorter(input, length);
        assertEquals("ab", result); // "ab", "bc", "cd" each appear twice, but "ab" appears first
    }

    @Test
    void testUniqueSubstrings() {
        String input = "abcdef";
        int length = 2;
        String result = StringFrequencySorter.substringFrequencySorter(input, length);
        assertEquals("ab", result); // all substrings are unique, return first
    }

    @Test
    void testLongerLengthThanInput() {
        String input = "abc";
        int length = 5;
        assertThrows(IllegalArgumentException.class, () ->
            StringFrequencySorter.substringFrequencySorter(input, length));
    }

    @Test
    void testLengthEqualsInputLength() {
        String input = "hello";
        int length = 5;
        assertThrows(IllegalArgumentException.class, () ->
            StringFrequencySorter.substringFrequencySorter(input, length));
    }

    @Test
    void testNullInput() {
        assertThrows(IllegalArgumentException.class, () ->
            StringFrequencySorter.substringFrequencySorter(null, 2));
    }

    @Test
    void testEmptyInput() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () ->
            StringFrequencySorter.substringFrequencySorter(input, 1));
    }

    @Test
    void testInputWithOnlyRepeats() {
        String input = "aaaaaa";
        int length = 2;
        String result = StringFrequencySorter.substringFrequencySorter(input, length);
        assertEquals("aa", result);
    }
}

