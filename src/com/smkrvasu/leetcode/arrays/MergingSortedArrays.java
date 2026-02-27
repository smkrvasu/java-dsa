package com.smkrvasu.leetcode.arrays;

import java.util.Arrays;

public class MergingSortedArrays {

    // schedule meeting
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6};

        System.out.println(Arrays.toString(mergeSorted(a, b)));

        int[] c = {1, 3, 4, 7, 0, 0, 0};
        int[] d = {2, 5, 6};
        mergeReverse(c, d, 4, 3);
        System.out.println(Arrays.toString(c));
    }

    // Time O(m + n)
    // Space O(m + n)
    private static int[] mergeSorted(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[] out = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        // pick smaller, put into result and move pointer
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                out[k++] = a[i++];
            } else {
                out[k++] = b[j++];
            }
        }

        // add remaining
        while (i < m)
            out[k++] = a[i++];
        while (j < n)
            out[k++] = b[j++];

        return out;
    }

    // Time O(m + n)
    // Space O(1)
    private static void mergeReverse(int[] a, int[] b, int m, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // i=2,j=2,k=5
        // 3>6?a[5]=5
        // i=2,j=1,k=4
        // 3>5?a[4]=5
        while (j >= 0) {
            if (i > 0 && a[i] > b[j]) {
                a[k--] = a[i--];
            } else {
                a[k--] = b[j--];
            }
        }
    }
}
