package com.smkrvasu.leetcode.heap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    // top 10, trending
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(topKFrequent(nums, k));
    }

    // Time O(n + m log k)
    // Space O(m + k)
    private static List<Integer> topKFrequent(int[] nums, int k) {

        // Frequency map
        Map<Integer, Long> freq = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(freq);

        // Min-heap by frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingLong(freq::get));

        // Keep heap size at most k
        for (int num : freq.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        // Build result
        List<Integer> out = new ArrayList<>(k);
        while (!minHeap.isEmpty())
            out.add(minHeap.poll());

        return out;
    }
}