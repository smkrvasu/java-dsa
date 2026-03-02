package com.smkrvasu.leetcode.arrays;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MinimumCommonElement {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3};
        int[] num2 = {2, 3, 4};
        System.out.println(getCommon(num1, num2));
    }

    private static int getCommon(int[]... arrs) {
        int n = arrs.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int[] arr : arrs) {
            Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
            for (Integer s : set)
                freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
        return freq.entrySet().stream()
                .filter(e -> e.getValue() == n)
                .mapToInt(Map.Entry::getKey)
                .min()
                .orElse(-1);
    }
}
