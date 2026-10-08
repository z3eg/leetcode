package com.company;

import com.company.util.list.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class _143 {

    /*4
ms
Beats
10.56%*/
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next==null)
            return;
        ListNode headP = head;
        Stack<ListNode> stack = new Stack<>();
        while (head!=null) {
            stack.add(head);
            head = head.next;
        }
        int halfSize = stack.size() / 2;
        int end = stack.size()%2==0?halfSize-1:halfSize;
        for (int i = 0; i < end; i++) {
            ListNode next = headP.next;
            ListNode pop = stack.pop();
            headP.next = pop;
            pop.next = next;
            headP = next;
        }
        ListNode pop = stack.pop();
        pop.next = null;
    }
}
