package com.smkrvasu.algomaster.arrays;

public class TripletSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
//        int[] arr = {5, 4, 3, 2, 1};
//        int[] arr = {2, 1, 5, 0, 4, 6};
        System.out.println(linearScan(arr));
    }

    private static boolean linearScan(int[] arr) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int n : arr) {
            if (n <= first)
                first = n;
            else if (n <= second)
                second = n;
            else
                return true;
        }
        return false;
    }
}
