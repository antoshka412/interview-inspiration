package org.problem.algorythm;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CharacterFrequencySorterTests {

    @Test
    void testBasicInput() {
        String input = "aA1@aA@";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('@', 2);
        expected.put('A', 2);
        expected.put('a', 2);
        expected.put('1', 1);

        Map<Character, Integer> result = CharacterFrequencySorter.countAndSortCharacters(input);
        assertEquals(expected, result);
    }

    @Test
    void testEmptyInput() {
        String input = "";
        Map<Character, Integer> result = CharacterFrequencySorter.countAndSortCharacters(input);
        assertTrue(result.isEmpty());
    }

    @Test
    void testOnlyInvalidCharacters() {
        String input = "!#$%^&*()_+=-";
        Map<Character, Integer> result = CharacterFrequencySorter.countAndSortCharacters(input);
        assertTrue(result.isEmpty());
    }

    @Test
    void testCaseSensitivity() {
        String input = "aAaA";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('A', 2);
        expected.put('a', 2);

        Map<Character, Integer> result = CharacterFrequencySorter.countAndSortCharacters(input);
        assertEquals(expected, result);
    }

    @Test
    void testDigitsAndLetters() {
        String input = "abc123321";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('1', 2);
        expected.put('2', 2);
        expected.put('3', 2);
        expected.put('a', 1);
        expected.put('b', 1);
        expected.put('c', 1);

        Map<Character, Integer> result = CharacterFrequencySorter.countAndSortCharacters(input);
        assertEquals(expected, result);
    }

    @Test
    void testSortingByAsciiOnTie() {
        String input = "bBaA";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('A', 1);
        expected.put('B', 1);
        expected.put('a', 1);
        expected.put('b', 1);

        Map<Character, Integer> result = CharacterFrequencySorter.countAndSortCharacters(input);
        assertEquals(expected, result);
    }

    @Test
    void testBasicInputOptimised() {
        String input = "aA1@aA@";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('@', 2);
        expected.put('A', 2);
        expected.put('a', 2);
        expected.put('1', 1);

        Map<Character, Integer> result = CharacterFrequencySorter.countAndSortCharactersOptimised(input);
        assertEquals(expected, result);
    }

    @Test
    void testEmptyInputOptimised() {
        String input = "";
        Map<Character, Integer> result = CharacterFrequencySorter.countAndSortCharactersOptimised(input);
        assertTrue(result.isEmpty());
    }

    @Test
    void testOnlyInvalidCharactersOptimised() {
        String input = "!#$%^&*()_+=-";
        Map<Character, Integer> result = CharacterFrequencySorter.countAndSortCharactersOptimised(input);
        assertTrue(result.isEmpty());
    }

    @Test
    void testCaseSensitivityOptimised() {
        String input = "aAaA";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('A', 2);
        expected.put('a', 2);

        Map<Character, Integer> result = CharacterFrequencySorter.countAndSortCharactersOptimised(input);
        assertEquals(expected, result);
    }

    @Test
    void testDigitsAndLettersOptimised() {
        String input = "abc123321";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('1', 2);
        expected.put('2', 2);
        expected.put('3', 2);
        expected.put('a', 1);
        expected.put('b', 1);
        expected.put('c', 1);

        Map<Character, Integer> result = CharacterFrequencySorter.countAndSortCharactersOptimised(input);
        assertEquals(expected, result);
    }

    @Test
    void testSortingByAsciiOnTieOptimised() {
        String input = "bBaA";
        Map<Character, Integer> expected = new LinkedHashMap<>();
        expected.put('A', 1);
        expected.put('B', 1);
        expected.put('a', 1);
        expected.put('b', 1);

        Map<Character, Integer> result = CharacterFrequencySorter.countAndSortCharactersOptimised(input);
        assertEquals(expected, result);
    }
}

