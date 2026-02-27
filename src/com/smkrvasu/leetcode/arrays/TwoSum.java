package com.smkrvasu.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Coupon target 1000 with billing items
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(findTwoSum(nums, target)));
    }

    // Time O(n)
    // Space O(n)
    private static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>(nums.length);
        // value, index
        seen.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {
            int need = target - nums[i];
            if (seen.containsKey(need))
                return new int[]{seen.get(need), i};
            seen.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }
}
