package com.smkrvasu.algomaster.arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(findMajority(nums));
    }

    // Invariant: After processing i element, if count > 0, candidate is the majority
    private static int findMajority(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int n : nums) {
            if (count == 0)
                candidate = n;
            count += n == candidate ? 1 : -1;
        }
        return candidate;
    }
}
