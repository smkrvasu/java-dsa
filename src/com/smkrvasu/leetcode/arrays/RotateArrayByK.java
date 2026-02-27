package com.smkrvasu.leetcode.arrays;

import java.util.Arrays;

public class RotateArrayByK {

    // seating arrangement
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

//        rotate(nums, k);
        rotateModIndex(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    // Time O(n)
    // Space O(1)
    private static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        if (k == 0)
            return;

        // Reverse all
        reverse(nums, 0, n - 1);
        // Reverse first
        reverse(nums, 0, k - 1);
        // Reverse rest
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    // Time O(n)
    // Space O(n)
    private static void rotateModIndex(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        if (k == 0)
            return;

        int[] out = new int[n];
        for (int i = 0; i < n; i++) {
            // An element at old[i] goes to new[(i+k)%n]
            out[(i + k) % n] = nums[i];
        }
        System.arraycopy(out, 0, nums, 0, n);
    }
}