package org.problem.algorythm;

import java.util.*;

/**
 * Calculate the number of occurrences of a specific symbol in a given string (1)
 * and return as a sorted map (2)
 * <p>
 * (1) latin letters any case, digits, @
 * (2) Sorting
 * a) by the # of occurrences desc
 * b) for the symbols with the same # of occurrences, sort by ASCII code asc
 */

public class CharacterFrequencySorter {

    public static Map<Character, Integer> countAndSortCharacters(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Step 1. Get valid characters & count them
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isLetterOrDigit(currentChar) || '@' == currentChar) {
                frequencyMap.merge(currentChar, 1, Integer::sum);
            }
        }

        // Step 2. Group characters by frequency using TreeMap
        Map<Integer, Set<Character>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            char currentChar = entry.getKey();
            int frequency = entry.getValue();
            sortedMap.computeIfAbsent(frequency, key -> new TreeSet<>()).add(currentChar);
        }

        // Step 3. Convert to LinkedHashMap to preserve precious order
        Map<Character, Integer> orderedMap = new LinkedHashMap<>(sortedMap.size());
        for (Map.Entry<Integer, Set<Character>> entry : sortedMap.entrySet()) {
            for (Character character : entry.getValue()) {
                orderedMap.put(character, entry.getKey());
            }
        }

        return orderedMap;
    }


    public static Map<Character, Integer> countAndSortCharactersOptimised(String input) {
        // 128 - ASCII range
        // index - ASCII of a symbol
        // value - # of occurrences
        int[] counts = new int[128];

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isLetterOrDigit(currentChar) || '@' == currentChar) {
                counts[currentChar]++;
            }
        }

        List<Character> symbols = new ArrayList<>();
        for (char c = 0; c < 128; c++) {
            if (counts[c] > 0) {
                symbols.add(c);
            }
        }

        symbols.sort((a, b) -> {
            int countA = counts[a];
            int countB = counts[b];
            return countA != countB ? Integer.compare(countB, countA) : Character.compare(a, b);
        });


        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (char c : symbols) {
            int count = counts[c];
            if (count > 0) {
                sortedMap.put(c, count);
            }
        }

        return sortedMap;
    }

    public static SequencedMap<Character, Integer> countAndSortCharactersBitWise(String input) {
        // 128 - ASCII range
        // index - ASCII of a symbol
        // value - # of occurrences in high bit + character in low bit
        long[] countAndChars = new long[128];

        for (int i = 0; i < input.length(); i++) {
            int character = input.charAt(i);

            if (Character.isLetterOrDigit(character) || '@' == character) {
                countAndChars[character] = (((countAndChars[character] >> 32) + 1L) << 32) | ((Integer.MAX_VALUE - character) & 0xFFFFFFFFL);
            }

        }

        Arrays.sort(countAndChars);

        SequencedMap<Character, Integer> countsByChar = new LinkedHashMap<>();

        for (int i = countAndChars.length - 1; i >= 0; i--) {
            long countAndChar = countAndChars[i];

            if (countAndChar == 0L) {
                continue;
            }

            countsByChar.put((char) (Integer.MAX_VALUE - (countAndChar & 0xFFFFFFFFL)), (int) (countAndChar >> 32));
        }

        return countsByChar;
    }


}
