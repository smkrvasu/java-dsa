package com.smkrvasu.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindKMissingNumbers {

    // find attendees
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 7};
        int n = 7;

        System.out.println(findMissingNumbers(nums, n));
    }

    // Time O(n)
    // Space O(n)
    private static List<Integer> findMissingNumbers(final int[] nums, final int n) {
        boolean[] seen = new boolean[n + 1];

        for (int num : nums) {
            seen[num] = true;
        }

        for (int i = 1; i < seen.length; i++) {
            if (!seen[i])
                System.out.println(i);
        }

        List<Integer> out = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!seen[i])
                out.add(i);
        }

        return out;
    }
}
