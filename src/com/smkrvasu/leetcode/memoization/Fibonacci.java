package com.smkrvasu.leetcode.memoization;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibOptimized(5));
        System.out.println(fibRecursive(5));
        System.out.println(fibDP(5));
        System.out.println(fibMemoization(5));
    }

    private static int fibMemoization(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fibHelper(n, memo);
    }

    private static int fibHelper(int n, int[] memo) {
        if (n <= 1)
            return n;
        if (memo[n] != -1)
            return memo[n];
        memo[n] = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);
        return memo[n];
    }

    private static int fibDP(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //  0,1,1,2,3,5,8
    // F0 1 2 3 4 5 6
    private static int fibOptimized(int n) {
        if (n <= 1)
            return n;
        int prev2 = 0; // F(0)
        int prev1 = 1; // F(1)
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    private static int fibRecursive(int n) {
        if (n <= 1)
            return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }
}
