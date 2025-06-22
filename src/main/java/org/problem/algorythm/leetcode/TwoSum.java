package org.problem.algorythm.leetcode;

import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such
 * that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same
 * element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1: Input: nums = [2,7,11,15], target = 9 Output: [0,1] Explanation: Because nums[0] +
 * nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2: Input: nums = [3,2,4], target = 6 Output: [1,2]
 * <p>
 * Example 3: Input: nums = [3,3], target = 6 Output: [0,1]
 */
public class TwoSum {

    public static int[] twoSumHashMap(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>(); //key: an element from array, value: index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }


    public static int[] twoSumInt2IntOpenHashMap(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        Int2IntOpenHashMap map = new Int2IntOpenHashMap(); // this map stores primitives so I assume it is faster than HashMap
        map.defaultReturnValue(-1);

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            int complementIndex = map.get(complement);

            if (complementIndex != -1 && complementIndex != i) {
                return new int[] { complementIndex, i };
            }

            map.put(nums[i], i);
        }

        return null;
    }

}
