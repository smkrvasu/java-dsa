package com.smkrvasu.algomaster.strings;

public class Subsequence {
    public static void main() {
        String input = "ahbgdc";
        String subSeq = "abc";
        System.out.println(findSubSeq(input, subSeq));
    }

    private static boolean findSubSeq(String input, String subSeq) {
        if (input == null || subSeq == null)
            return false;
        if (subSeq.isEmpty())
            return true;
        int i = 0;
        int j = 0;
        while (i < input.length() && j < subSeq.length()) {
            if (input.charAt(i) == subSeq.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == subSeq.length();
    }
}
