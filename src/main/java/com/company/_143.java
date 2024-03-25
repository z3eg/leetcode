package com.company;

import com.company.util.list.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class _143 {
    public void reorderList(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        ListNode head2 = head;
        while (head2.next!=null) {
            stack.add(head2);
            head2 = head2.next;
        }
        head2 = head;
        int len = stack.size();
        while (stack.size()>len/2) {
            ListNode node = stack.pop();
            node.next = head2.next;
            head2.next = node;
            head2 = node.next;
        }
    }
}
