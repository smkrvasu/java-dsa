package com.smkrvasu.algorithms.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        final int[] array = new int[]{31, 41, 59, 26, 41, 58};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (i >= 0 && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }
}
