package com.smkrvasu.leetcode.arrays;

public class CompressString {

    // log compression, data compression
    public static void main(String[] args) {
        String input = "aabcccccaaa";
        System.out.println(compress(input));
    }

    // Time O(n)
    // Space O(n)
    private static String compress(String input) {
        if (input == null || input.length() <= 1)
            return input;

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= input.length(); i++) {
            // if same, increase count
            if (i < input.length() && input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                // append char and count, reset count
                sb.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        return sb.length() < input.length() ? sb.toString() : input;
    }
}
