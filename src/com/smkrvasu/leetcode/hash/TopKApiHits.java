package com.smkrvasu.leetcode.hash;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKApiHits {

    // Most hit APIs, Auto scale hot endpoints, generate dashboard
    // high priority task
    public static void main(String[] args) {

        List<String> input = List.of("login", "search", "login", "home", "search", "login");
        int k = 2;
        System.out.println(findTopKApis(input, k));
    }

    private static List<String> findTopKApis(List<String> input, int k) {
        return input.stream()
                // Count frequency
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                // sort based on frequency
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                // Extract top K
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }
}
