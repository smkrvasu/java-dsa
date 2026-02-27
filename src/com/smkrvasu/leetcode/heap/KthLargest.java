package com.smkrvasu.leetcode.heap;

import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int n : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(n);
            }
            // if n is greater than the smallest element in the heap
            // then n deserves a place in the heap
            // because heap can contain K large elements
            else if (n > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(n);
            }
        }
        return minHeap.peek();
    }
}
