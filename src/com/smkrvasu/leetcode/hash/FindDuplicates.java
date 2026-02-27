package com.smkrvasu.leetcode.hash;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicates {

    // duplicate transactions, registration, events
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 4, 1, 5};

        System.out.println(containsDuplicate(nums));
        System.out.println(findDuplicates(nums));
        System.out.println(findOccurrenceOfDuplicates(nums));
    }

    // Time O(n)
    // Space O(n)
    private static List<Integer> findDuplicates(int[] nums) {
        Set<Integer> duplicate = new HashSet<>(nums.length);
        return Arrays.stream(nums)
                .boxed()
                .filter(i -> !duplicate.add(i))
                .toList();
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicate = ConcurrentHashMap.newKeySet();
        return Arrays.stream(nums)
                .parallel()
                .anyMatch(i -> !duplicate.add(i));
    }

    private static Map<Integer, Long> findOccurrenceOfDuplicates(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
