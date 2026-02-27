package com.smkrvasu.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

public class PairWithGivenDifference {

    // transaction amount fraud pattern, reading differs by threshold
    public static void main(String[] args) {
        int[] nums = {5, 20, 83, 2, 50, 80};
        int k = 78;
        System.out.println(hasPairWithDifference(nums, k));
    }

    // Time O(n)
    // Space O(n)
    private static boolean hasPairWithDifference(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {

            System.out.printf("%d    %d  %d\n", x, x + k, x - k);

            // Check both possibilities
            if (set.contains(x + k) || set.contains(x - k))
                return true;
            // Add to set
            set.add(x);
        }
        return false;
    }
}
