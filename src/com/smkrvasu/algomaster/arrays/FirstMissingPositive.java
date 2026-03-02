package com.smkrvasu.algomaster.arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0};
        System.out.println(findNum(arr));
    }

    private static int findNum(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // valid home: arr[i] > 0 && arr[i] <= n
            // not in home: arr[i] != arr[arr[i] - 1]
            while (arr[i] > 0 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
                int correctIdx = arr[i] - 1;
                int temp = arr[correctIdx];
                arr[correctIdx] = arr[i];
                arr[i] = temp;
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] != j + 1)
                return j + 1;
        }
        return n + 1;
    }
}
