package com.smkrvasu.leetcode.dp;

public class ClimbStairs {

    // payment splitting
    public static void main(String[] args) {
        int n = 3;
        System.out.println(calcWays(n));
    }

    // Time O(n)
    // Space O(1)
    private static int calcWays(int n) {
        if (n <= 1)
            return 1;

        int p1 = 1;
        int p2 = 1;

        for (int i = 2; i <= n; i++) {
            int cur = p1 + p2;
            p2 = p1;
            p1 = cur;
        }
        return p1;
    }
}
