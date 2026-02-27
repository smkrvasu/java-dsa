package com.smkrvasu.leetcode.arrays;

import java.util.Arrays;

public class MoveZeroesToEnd {

    // unbooked to end, invalid to end
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    // [0, 1, 0, 3, 12]
    // [1, 0, 0, 3, 12]
    // [1, 0, 0, 3, 12]
    // [1, 3, 0, 0, 12]
    // [1, 3, 12, 0, 0]

    // Time O(n)
    // Space O(1)
    private static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            // if nums[i] == 0, do nothing
            // if nums[i] != 0, swap, move j
            if (nums[i] != 0) {
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }
        }
    }
}
