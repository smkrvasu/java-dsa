package com.smkrvasu.algomaster.arrays;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] input = {2, 1, 0, 3, 12};
        System.out.println(Arrays.toString(moveZerosToEnd(input)));
    }

    // Invariant: All elements before write are non-zero
    private static int[] moveZerosToEnd(int[] input) {
        if (input == null || input.length < 2)
            return input;
        int write = 0;

        for (int read = 0; read < input.length; read++) {
            if (input[read] != 0) {
                if (read != write) {
                    int temp = input[write];
                    input[write] = input[read];
                    input[read] = temp;
                }
                write++;
            }
        }
        return input;
    }
}
