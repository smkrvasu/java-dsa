package com.smkrvasu.algomaster.arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {

        int[] nums = {0, 1, 1, 2};
        System.out.println(remove(nums));
    }

    // Invariant: All elements before write are unique
    private static int remove(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int write = 1;
        for (int read = 1; read < nums.length; read++) {
            if (nums[read] != nums[read - 1])
                nums[write++] = nums[read];
        }
        return write;
    }
}
