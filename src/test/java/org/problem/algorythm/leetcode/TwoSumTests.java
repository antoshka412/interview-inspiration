package org.problem.algorythm.leetcode;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwoSumTests {

    @Test
    void testTwoSumHashMap_basicCases() {
        assertArrayEquals(new int[]{0, 1}, TwoSum.twoSumHashMap(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, TwoSum.twoSumHashMap(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{0, 1}, TwoSum.twoSumHashMap(new int[]{3, 3}, 6));
    }

    @Test
    void testTwoSumHashMap_noSolution() {
        assertNull(TwoSum.twoSumHashMap(new int[]{1, 2, 3}, 7));
    }

    @Test
    void testTwoSumHashMap_nullOrShortInput() {
        assertNull(TwoSum.twoSumHashMap(null, 5));
        assertNull(TwoSum.twoSumHashMap(new int[]{}, 5));
        assertNull(TwoSum.twoSumHashMap(new int[]{1}, 1));
    }

    @Test
    void testTwoSumInt2IntOpenHashMap_basicCases() {
        assertArrayEquals(new int[]{0, 1}, TwoSum.twoSumInt2IntOpenHashMap(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, TwoSum.twoSumInt2IntOpenHashMap(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{0, 1}, TwoSum.twoSumInt2IntOpenHashMap(new int[]{3, 3}, 6));
    }

    @Test
    void testTwoSumInt2IntOpenHashMap_noSolution() {
        assertNull(TwoSum.twoSumInt2IntOpenHashMap(new int[]{1, 2, 3}, 7));
    }

    @Test
    void testTwoSumInt2IntOpenHashMap_nullOrShortInput() {
        assertNull(TwoSum.twoSumInt2IntOpenHashMap(null, 5));
        assertNull(TwoSum.twoSumInt2IntOpenHashMap(new int[]{}, 5));
        assertNull(TwoSum.twoSumInt2IntOpenHashMap(new int[]{1}, 1));
    }

    @Test
    void testTwoSumWithDuplicates() {
        int[] arr = {1, 3, 3, 4};
        int target = 6;
        assertArrayEquals(new int[]{1, 2}, TwoSum.twoSumHashMap(arr, target));
        assertArrayEquals(new int[]{1, 2}, TwoSum.twoSumInt2IntOpenHashMap(arr, target));
    }
}

