package com.company;

import com.company.util.list.ListNode;

public class _19 {

    /*Wrong Answer
190 / 208 testcases passed*/
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next==null) {
            return null;
        }
        ListNode headPointer = head;
        ListNode headPointer2 = head;
        int counter = 1;
        while (head.next!=null) {
            head = head.next;
            counter++;
        }
        counter-=n;
        counter--;
        int newCounter = 0;
        while (newCounter<counter) {
            headPointer = headPointer.next;
            newCounter++;
        }
        if (headPointer.next!=null)
            headPointer.next = headPointer.next.next;
        return headPointer2;
    }

}
