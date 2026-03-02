package com.smkrvasu.leetcode.subset;

import java.util.List;
import java.util.ArrayList;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(subsets(arr));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currSubset = new ArrayList<>();
        backTrack(nums, 0, currSubset, result);
        return result;
    }

    private static void backTrack(int[] nums, int startIdx, List<Integer> currSubset, List<List<Integer>> result) {
        result.add(List.copyOf(currSubset));
        for (int i = startIdx; i < nums.length; i++) {
            currSubset.add(nums[i]);
            backTrack(nums, i + 1, currSubset, result);
            currSubset.remove(currSubset.size() - 1);
        }
    }
}
