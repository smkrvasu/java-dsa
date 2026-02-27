package com.smkrvasu.leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    // Max-heap for lower half
    private static PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
    // Min-heap for upper half
    private static PriorityQueue<Integer> upper = new PriorityQueue<>(Integer::compareTo);

    // Median latency of request in realtime
    public static void main(String[] args) {
        int[] nums = new int[]{5, 15, 1, 3};

        for (int n : nums) {
            addNum(n);
            System.out.println(findMedian());
        }
    }

    private static double findMedian() {
        if (lower.size() > upper.size()) {
            return lower.peek();
        } else {
            return (lower.peek() + upper.peek()) / 2.0;
        }
    }

    // Time O(log n)
    // Space O(n)
    private static void addNum(int n) {
        // add to heap
        if (lower.isEmpty() || n <= lower.peek()) {
            lower.offer(n);
        } else {
            upper.offer(n);
        }

        // rebalance
        if (lower.size() > upper.size() + 1) {
            upper.offer(lower.poll());
        } else if (upper.size() > lower.size()) {
            lower.offer(upper.poll());
        }
    }
}
