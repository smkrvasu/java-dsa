package com.smkrvasu.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    // text parsing, unique token IDs, unique packetIDs
    public static void main(String[] args) {

        String input = "strings";
        System.out.println(findLongestSubstring(input));
    }

    // Time O(n)
    // Space O(n)
    private static String findLongestSubstring(String input) {
        if (input == null || input.isEmpty())
            return "";

        // "left" -> start of the sliding window
        // "right" -> end of the sliding window
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int currLen = 0;
        int currStart = 0;

        for (int right = 0; right < input.length(); right++) {
            char c = input.charAt(right);

            if (lastSeen.containsKey(c) && lastSeen.get(c) >= left) {
                left = lastSeen.get(c) + 1;
            }
            lastSeen.put(c, right);

            int windowLen = right - left + 1;
            if (windowLen > currLen) {
                currLen = windowLen;
                currStart = left;
            }
        }
        return input.substring(currStart, currStart + currLen);
    }
}
