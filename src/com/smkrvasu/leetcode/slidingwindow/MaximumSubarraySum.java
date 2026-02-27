package com.smkrvasu.leetcode.slidingwindow;

public class MaximumSubarraySum {

    // day profit/loss, max strike, spike
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    // Time O(n)
    // Space O(1)
    private static int maxSubArray(int[] nums) {
        int prevSubArraySum = nums[0];
        int maxSubArraySum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // Is it better to extend previous subarray, or start a new subarray?
            prevSubArraySum = Math.max(prevSubArraySum + nums[i], nums[i]);
            maxSubArraySum = Math.max(prevSubArraySum, maxSubArraySum);
        }
        return maxSubArraySum;
    }
}
