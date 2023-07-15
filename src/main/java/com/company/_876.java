package com.company;

import com.company.util.list.ListNode;

/*876. Middle of the Linked List
        https://leetcode.com/problems/middle-of-the-linked-list/*/
public class _876 {
    /*-ms
    Beats 100.00%of users with Java*/
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        while (fast.next!=null && fast.next.next!=null) {
            head = head.next; //head is slow pointer
            fast = fast.next.next;
        }
        if (fast.next!=null)
            head = head.next;
        return head;
    }
}
