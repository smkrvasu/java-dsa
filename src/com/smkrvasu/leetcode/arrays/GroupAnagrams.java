package com.smkrvasu.leetcode.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    // word games, spell‑checkers, search engines, and text‑processing systems
    public static void main(String[] args) {
        List<String> input = List.of("eat", "tea", "tan", "ate", "nat", "bat");

        System.out.println(groupIt(input));
        String[] strings = new String[input.size()];
        System.out.println(groupAnagrams(input.toArray(strings)));
    }

    // Sort O(k log k)
    // Time O(n * k log k)
    // Space O(n * k)
    private static List<List<String>> groupIt(List<String> input) {
        Map<String, List<String>> group = new HashMap<>();

        for (String s : input) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);
            group.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(group.values());
    }

    private static List<List<String>> groupAnagrams(String[] input) {
        return Arrays.stream(input)
                .collect(Collectors.groupingBy(s -> {
                    char[] arr = s.toCharArray();
                    Arrays.sort(arr);
                    return new String(arr);
                }))
                .values().stream()
                .map(group -> group.stream().sorted().toList())
                .sorted(Comparator.comparing(List::size))
                .toList();
    }
}
