package com.smkrvasu.leetcode.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TaskScheduler {

    // CPU scheduling, API throttling, unique items in each window
    public static void main(String[] args) {
        char[] tasks = "AAABBB".toCharArray();
        int n = 2;
        int out = leastInterval(tasks, 2);
        System.out.println(out);
    }

    // Time O(T)
    // Space O(1)
    private static int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;

        // frequency
        int[] freq = new int[26];
        for (char c : tasks)
            freq[c - 'A']++;

        // Max heap by frequency
        PriorityQueue<Integer> maxHeap = IntStream.of(freq)
                .filter(f -> f > 0)
                .boxed()
                .collect(Collectors.toCollection(() -> new PriorityQueue<>(Collections.reverseOrder())));

        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> used = new ArrayList<>();
            int cycle = n + 1;
            // AB_
            // AB_AB_
            // AB_AB_AB
            while (cycle > 0 && !maxHeap.isEmpty()) {
                // highest remaining frequency
                int cnt = maxHeap.poll();
                // execution of task
                cnt--;
                // store remaining temporarily
                if (cnt > 0)
                    used.add(cnt);
                // time used
                time++;
                // cycle used
                cycle--;
            }
            // push remaining to heap
            used.forEach(maxHeap::offer);
            // idle cycle
            if (!maxHeap.isEmpty())
                time += cycle;
        }
        return time;
    }

}
