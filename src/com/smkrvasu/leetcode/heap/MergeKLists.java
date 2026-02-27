package com.smkrvasu.leetcode.heap;

import com.smkrvasu.leetcode.linkedlist.LinkedListUtils;
import com.smkrvasu.leetcode.linkedlist.Node;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {

    // merge sorted logs from different server
    // merge sorted event stream from kafka partition
    public static void main(String[] args) {
        Node l1 = LinkedListUtils.build(new int[]{1, 4, 5});
        Node l2 = LinkedListUtils.build(new int[]{1, 3, 4});
        Node l3 = LinkedListUtils.build(new int[]{2, 6});
        List<Node> list = List.of(l1, l2, l3);

        LinkedListUtils.print(merge(list));
    }

    // Time O(n log k)
    // Space O(k)
    private static Node merge(List<Node> list) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // push all heads
        for (Node n : list) {
            minHeap.offer(n);
        }

        Node dummyHead = new Node(-1);
        Node tail = dummyHead;

        while (!minHeap.isEmpty()) {
            Node minNode = minHeap.poll();
            tail.next = minNode;
            tail = tail.next;

            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }

        return dummyHead.next;
    }
}
