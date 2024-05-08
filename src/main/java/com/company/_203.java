package com.company;

import com.company.util.list.ListNode;

public class _203 {

    /*Wrong Answer
50 / 66 testcases passed*/
    /*public ListNode removeElements(ListNode head, int val) {
        while (head!= null && head.val == val)
            head = head.next;
        ListNode headPointer = head;
        while (head!=null && head.next!=null) {
            if (head.next.val==val)
                head.next = head.next.next;
            head = head.next;
        }
        return headPointer;
    }*/

    /*1
    ms
            Beats
92.27%
    of users with Java*/
    public ListNode removeElements(ListNode head, int val) {
        while (head!= null && head.val == val)
            head = head.next;
        ListNode headPointer = head;
        while (head!=null && head.next!=null) {
            while (head.next!= null && head.next.val==val)
                head.next = head.next.next;
            head = head.next;
        }
        return headPointer;
    }
}
