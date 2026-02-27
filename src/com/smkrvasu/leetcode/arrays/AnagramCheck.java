package com.smkrvasu.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class AnagramCheck {

    // password/token validation, spell check, text parsing, data cleanup in DB, log analysis
    public static void main(String[] args) {
        String text1 = "listen";
        String text2 = "silent";
//        System.out.println(isAnagram(text1, text2));
        System.out.println(isAnagramLowerCase(text1, text2));
    }

    // Time O(n)
    // Space O(1) constant 26
    private static boolean isAnagramLowerCase(String s, String t) {
//        if (text1.length() != text2.length())
//            return false;
//
//        int[] freq = new int[26];
//
//        for (int i = 0; i < text1.length(); i++) {
//            // 'a' -> 97, 'b' -> 98
//            // 'a' - 'a' -> 0
//            // ++/-- increase/decrease frequency
//            freq[text1.charAt(i) - 'a']++;
//            freq[text2.charAt(i) - 'a']--;
//        }
//
//        // every count returns to 0
//        for (int x : freq)
//            if (x != 0)
//                return false;
//
//        return true;
        if (s.length() != t.length())
            return false;

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
            if (freq[c - 'a'] != 0)
                return false;
        }
        return true;
    }

    // Time O(n)
    // Space O(k) unique characters
    private static boolean isAnagram(String text1, String text2) {
        if (text1.length() != text2.length())
            return false;
        Map<Character, Integer> count = new HashMap<>();

        for (Character c : text1.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (Character t : text2.toCharArray()) {
            if (!count.containsKey(t))
                return false;
            count.put(t, count.getOrDefault(t, 0) - 1);

            if (count.get(t) < 0)
                return false;
        }
        return true;
    }
}
