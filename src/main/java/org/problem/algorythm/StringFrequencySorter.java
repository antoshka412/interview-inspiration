package org.problem.algorythm;

import java.util.HashMap;
import java.util.Map;

public class StringFrequencySorter {

    /**
     * Finds and returns the most frequently occurring substring of a specified length from the
     * given input string.
     *
     * <p>If multiple substrings have the same maximum frequency, the method returns
     * the one that appears first in the input string.</p>
     *
     * @param input  the input string to search for substrings
     * @param length the length of substrings to consider
     * @return the substring of the specified length that appears most frequently
     * @throws IllegalArgumentException if the input string is {@code null} or shorter than or equal
     *                                  to the specified length
     */
    public static String substringFrequencySorter(String input, int length) {
        if (input == null || input.length() <= length) {
            throw new IllegalArgumentException(
                "Input string must be non-null and longer than the specified length.");
        }

        Map<String, Integer> frequencyMap = new HashMap<>();
        String mostFrequentSubstring = "";
        int maxFrequency = 0;

        for (int i = 0; i <= input.length() - length; i++) {
            String substring = input.substring(i, i + length);
            int frequency = frequencyMap.getOrDefault(substring, 0) + 1;
            frequencyMap.put(substring, frequency);

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostFrequentSubstring = substring;
            }
        }

        return mostFrequentSubstring;
    }


}
