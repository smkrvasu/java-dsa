package com.smkrvasu.algomaster.arrays;

public class ZeroFilledSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 0, 2, 0, 0, 4};
        System.out.println(countSubArray(arr));
        System.out.println(linearScan(arr));
    }

    private static int linearScan(int[] arr) {
        int count = 0;
        int consecutive = 0;
        for (int n : arr) {
            if (n == 0) {
                consecutive++;
                count += consecutive;
            } else
                consecutive = 0;
        }
        return count;
    }

    private static int countSubArray(int[] arr) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n && arr[j] == 0; j++) {
                count++;
            }
        }
        return count;
    }
}
