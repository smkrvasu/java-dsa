package com.smkrvasu.leetcode.linkedlist;

public class ReverseLinkedList {
    // rollback
    public static void main(String[] args) {
        Node node = LinkedListUtils.build(new int[]{1, 2, 2, 2, 1});
//        LinkedListUtils.print(node);
//        LinkedListUtils.print(reverseList(node));
        System.out.println(isPalindrome(node));
    }

    private static boolean isPalindrome(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node prev = null;
        Node curr = slow;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = prev;
            prev = copy;
            curr = curr.next;
        }
        Node p1 = head;
        Node p2 = prev;
        while (p2 != null) {
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    // Time O(n)
    // Space O(1)
    private static Node reverseList(final Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
