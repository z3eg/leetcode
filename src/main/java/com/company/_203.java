package com.company;

import com.company.util.list.ListNode;

public class _203 {

    /*Wrong Answer
50 / 66 testcases passed*/
    public ListNode removeElements(ListNode head, int val) {
        while (head!= null && head.val == val)
            head = head.next;
        ListNode headPointer = head;
        while (head!=null && head.next!=null) {
            if (head.next.val==val)
                head.next = head.next.next;
            head = head.next;
        }
        return headPointer;
    }
}
