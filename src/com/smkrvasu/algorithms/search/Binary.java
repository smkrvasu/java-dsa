package com.smkrvasu.algorithms.search;

public class Binary {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 4;
        System.out.println(findIndex(nums, k));
    }

    private static int findIndex(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == k)
                return mid;
            else if (k > nums[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
