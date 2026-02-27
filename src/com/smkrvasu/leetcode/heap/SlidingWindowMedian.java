package com.smkrvasu.leetcode.heap;

import java.util.Arrays;

public class SlidingWindowMedian {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 15, 1, 3};
        int k = 4;
        DualHeap dh = new DualHeap(k);
        double[] out = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            dh.add(nums[i]);
            if (i >= k)
                dh.remove(nums[i - k]);
            if (i >= k - 1)
                out[i - k + 1] = dh.getMedian();
        }
        System.out.println(Arrays.toString(out));
    }
}
