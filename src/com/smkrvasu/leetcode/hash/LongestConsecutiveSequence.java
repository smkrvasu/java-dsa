package com.smkrvasu.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    // longest chain, gaps
    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(findLongestConsecutiveSequence(nums));
    }

    // Time O(n)
    // Space O(n)
    private static int findLongestConsecutiveSequence(int[] nums) {
        // size > capacity * 0.75
        int initialCapacity = (int) (1000 * 0.75f) + 1;
        Set<Integer> seen = new HashSet<>(initialCapacity);
        for (int n : nums)
            seen.add(n);

        int longest = 0;
        for (int num : seen) {
            // if not in the set then this is start of the sequence
            if (!seen.contains(num - 1)) {
                int currentNum = num;
                int count = 1;
                // count all consecutive numbers
                while (seen.contains(currentNum + 1)) {
                    count++;
                    currentNum++;
                }
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
