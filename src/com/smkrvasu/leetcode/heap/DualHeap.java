package com.smkrvasu.leetcode.heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DualHeap {

    // Max-heap for lower half
    private final PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());

    // Min-heap for upper half
    private final PriorityQueue<Integer> upper = new PriorityQueue<>();

    private final int window;

    // delayed deletions
    private Map<Integer, Integer> delayed = new HashMap<>();

    private int lowerSize = 0;
    private int upperSize = 0;


    public DualHeap(int window) {
        this.window = window;
    }

    void add(int num) {
        if (lower.isEmpty() || num <= lower.peek()) {
            lower.offer(num);
            lowerSize++;
        } else {
            upper.offer(num);
            upperSize++;
        }
        balance();
    }

    void remove(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);
        if (!lower.isEmpty() && num <= lower.peek()) {
            lowerSize--;
            if (num == lower.peek())
                prune(lower);
        } else {
            upperSize--;
            if (!upper.isEmpty() && num == upper.peek())
                prune(upper);
        }
        balance();
    }

    double getMedian() {
        prune(lower);
        prune(upper);

        if (lowerSize > upperSize) {
            return (long) lower.peek();
        } else {
            return ((long) lower.peek() + (long) upper.peek()) / 2.0;
        }
    }

    private void balance() {
        if (lowerSize > upperSize + 1) {
            upper.offer(lower.poll());
            lowerSize--;
            upperSize++;
            prune(lower);
        } else if (upperSize > lowerSize) {
            lower.offer(upper.poll());
            lowerSize++;
            upperSize--;
            prune(upper);
        }
    }

    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            Integer cnt = delayed.get(num);
            if (cnt == null)
                break;
            if (cnt == 1)
                delayed.remove(num);
            else
                delayed.put(num, cnt - 1);
            heap.poll();
        }
    }
}
