package com.smkrvasu.leetcode.linkedlist;

public class MiddleOfLinkedList {

    // partitioning, load balancing
    public static void main(String[] args) {
        Node node = LinkedListUtils.build(new int[]{1, 2, 3, 4, 5, 6});
        Node middleNode = findMiddleNode(node);
        System.out.println(middleNode.val);
    }

    private static Node findMiddleNode(final Node node) {
        Node slow = node;
        Node fast = node;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
