package com.smkrvasu.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    // first non repeated error code, unique event type, unique transaction
    public static void main(String[] args) {
        String input = "hash";
        System.out.println(findFirstUnique(input));
    }

    // Time O(n)
    // Space O(1)
    private static int findFirstUnique(String input) {
        // character -> [count, firstIndex]
        Map<Character, int[]> map = new HashMap<>(input.length());

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
//            if (map.containsKey(c)) {
//                // increment count
//                map.get(c)[0]++;
//            } else {
//                // new
//                map.put(c, new int[]{1, i});
//            }
            map.merge(c, new int[]{1, i}, (existingVal, newVal) -> {
                existingVal[0]++;
                return existingVal;
            });
        }

        return map.values().stream()
                .filter(v -> v[0] == 1)
                .mapToInt(v -> v[1])
                .min()
                .orElse(-1);
    }
}
