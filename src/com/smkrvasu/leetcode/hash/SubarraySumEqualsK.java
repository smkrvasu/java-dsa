package com.smkrvasu.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    // longest streak
    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(subarraySum(nums, 3));
    }

    // Time O(n)
    // Space O(n)
    private static int subarraySum(int[] nums, int k) {
        // Subarray count
        int count = 0;
        // Cumulative sum
        int prefixSum = 0;
        // Key   -> Prefix Sum
        // Value -> Number of times this prefix sum has occurred
        Map<Integer, Integer> map = new HashMap<>();
        // subarray start from 0 and itself sum to 0
        map.put(0, 1);

        for (int num : nums) {
            prefixSum += num;
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
            if (map.containsKey(prefixSum - k))
                count += map.get(prefixSum - k);
        }

        return count;
    }
}
