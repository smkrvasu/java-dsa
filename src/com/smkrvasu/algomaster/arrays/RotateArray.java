package com.smkrvasu.algomaster.arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println(Arrays.toString(rotateRight(input, k)));
        System.out.println(Arrays.toString(rotateLeft(input, k)));
    }

    // Invariant: (i+k)%n
    private static int[] rotateRight(int[] input, int k) {
        int n = input.length;
        k = k % n;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = input[i];
        }
        return result;
    }

    private static int[] rotateLeft(int[] input, int k) {
        int n = input.length;
        k = k % n;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = input[(i + k) % n];
        }
        return result;
    }
}
