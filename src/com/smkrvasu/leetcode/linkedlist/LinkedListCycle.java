package com.smkrvasu.leetcode.linkedlist;

public class LinkedListCycle {

    // Time O(n)
    // Space O(1)
    private static boolean hasCycle(Node head) {
        if (head == null)
            return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow)
                return true;
        }
        return false;
    }

    private static Node detectCycle(Node head) {
        Node pos = new Node(-1);
        Node fast = head;
        Node slow = head;
        int fastCount = 0;
        int slowCount = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            fastCount += 2;
            slowCount += 1;
            if (fast == slow)
                break;
        }
        pos.val += fastCount - slowCount;
        return pos;
    }

    // memory leaks, garbage collection
    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(2);
        Node n3 = new Node(0);
        Node n4 = new Node(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        System.out.println(hasCycle(n1));
        System.out.println(detectCycle(n1).val);
    }
}
