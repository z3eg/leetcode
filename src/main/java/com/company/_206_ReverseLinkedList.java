package com.company;

import com.company.util.list.ListNode;

//https://leetcode.com/problems/reverse-linked-list/description/
public class _206_ReverseLinkedList {
    /*0ms
    Beats 100.00%of users with Java*/
    public ListNode reverseList(ListNode head) {
        if (head==null)
            return null;
        ListNode newHead = new ListNode(head.val);
        while (head.next!=null) {
            ListNode cur = newHead;
            newHead = new ListNode(head.next.val);
            newHead.next = cur;
            head = head.next;
        }
        return newHead;
    }
}
