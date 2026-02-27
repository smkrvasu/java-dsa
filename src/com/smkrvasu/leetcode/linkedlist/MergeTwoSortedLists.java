package com.smkrvasu.leetcode.linkedlist;

public class MergeTwoSortedLists {
    // merge two timelines
    public static void main(String[] args) {

        Node n1 = LinkedListUtils.build(new int[]{1, 2, 3});
        Node n2 = LinkedListUtils.build(new int[]{1, 3, 4, 5});

        Node out = merge(n1, n2);
        LinkedListUtils.print(out);
    }

    // Time O(m+n)
    // Space O(1)
    // 1->2->3->null
    // 1->3->4->5->null
    private static Node merge(final Node list1, final Node list2) {
        Node p1 = list1;
        Node p2 = list2;

        Node dummyHead = new Node(-1);
        Node tail = dummyHead;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                tail.next = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        tail.next = p1 != null ? p1 : p2;
        return dummyHead.next;
    }
}
