package com.smkrvasu.algomaster.arrays;

import java.util.Arrays;

public class ProductArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    private static int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        result[0] = 1;
        // left product to result
        for (int i = 1; i < n; i++) {
            result[i] = arr[i - 1] * result[i - 1];
        }
        // multiply by right cumulative
        int right = 1;
        for (int j = n - 1; j >= 0; j--) {
            result[j] *= right;
            right *= arr[j];
        }
        return result;
    }
}
