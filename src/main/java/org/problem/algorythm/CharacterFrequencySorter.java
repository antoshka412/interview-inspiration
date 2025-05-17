package org.problem.algorythm;

import java.util.*;

public class CharacterFrequencySorter {

    /**
     * Calculate the number of occurrences of a specific symbol in a given string (1)
     * and return as a sorted map (2)
     * <p>
     * (1) latin letters any case, digits, @
     * (2) Sorting
     * a) by the # of occurrences desc
     * b) for the symbols with the same # of occurrences, sort by ASCII code asc
     */
    public static Map<Character, Integer> countAndSortCharacters(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Step 1. Get valid characters & count them
        for (char currentChar : input.toCharArray()) {
            if (Character.isLetterOrDigit(currentChar) || '@' == currentChar) {
                frequencyMap.merge(currentChar, 1, Integer::sum);
            }
        }

        // Step 2. Group characters by frequency using TreeMap
        Map<Integer, Set<Character>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            char currentChar = entry.getKey();
            int frequency = entry.getValue();
            sortedMap.computeIfAbsent(frequency, _ -> new TreeSet<>()).add(currentChar);
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

}
