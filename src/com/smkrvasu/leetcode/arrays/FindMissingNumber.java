package com.smkrvasu.leetcode.arrays;

public class FindMissingNumber {

    // missing invoice
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        int n = 5;

        System.out.println(missingNumberSum(nums, n));
        System.out.println(missingNumberXor(nums, n));
        System.out.println(missingNumberXor(new int[]{0, 1, 2, 4}));
    }

    // Time O(n)
    // Space O(1)
    private static int missingNumberSum(final int[] nums, final int n) {
        long expected = (long) n * (n + 1) / 2;
        long actual = 0;
        for (int num : nums) {
            actual += num;
        }
        return (int) (expected - actual);
    }

    private static int missingNumberXor(final int[] nums, final int n) {
        // 1^1^2^2^3^3^4^5^5
        // xor cancels all except 4
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            xor ^= (i + 1);
        }
        xor ^= n;
        return xor;
    }

    private static int missingNumberXor(final int[] nums) {
        // 1^1^2^2^3^3^4^5^5
        // xor cancels all except 4
        int n = nums.length;
        int xor = n;
        for (int i = 0; i < n; i++) {
            int before = xor;
            // XOR with index i
            xor ^= i;
            System.out.printf("i=%d | after XOR with i: %d -> %d%n", i, before, xor);

            // XOR with value nums[i]
            int beforeVal = xor;
            xor ^= nums[i];
            System.out.printf("i=%d, nums[i]=%d | after XOR with nums[i]: %d -> %d%n", i, nums[i], beforeVal, xor);
        }
        return xor;
    }
}
