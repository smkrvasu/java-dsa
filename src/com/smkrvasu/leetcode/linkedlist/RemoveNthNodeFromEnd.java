package com.smkrvasu.leetcode.linkedlist;

public class RemoveNthNodeFromEnd {

    // Incoming request -> add to end -> if (limit+1) exists -> remove
    public static void main(String[] args) {
        Node node = LinkedListUtils.build(new int[]{1});
        LinkedListUtils.print(node);
        node = removeNthNode(node, 1);
        LinkedListUtils.print(node);
    }

    // Time O(n)
    // Space O(1)
    private static Node removeNthNode(final Node node, int n) {
        Node dummy = new Node(-1);
        dummy.next = node;
        Node slow = dummy;
        Node fast = dummy;

        // Move fast n+1 steps ahead to keep gap of n nodes between slow and fast
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        // Move both until fast hits null
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // slow is before node to remove
        slow.next = slow.next.next;
        return dummy.next;
    }
}
