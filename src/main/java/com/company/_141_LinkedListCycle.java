package com.company;

//https://leetcode.com/problems/linked-list-cycle/
public class _141_LinkedListCycle {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //1 ms
    public boolean hasCycle(ListNode head) {
        if (head!=null && head.next!=null && head.next.next!=null) {
            ListNode pointerA = head.next;
            ListNode pointerB = head.next.next;
            while (pointerA.next!=null && pointerB.next!=null && pointerB.next.next!=null) {
                if (pointerA.equals(pointerB)) {
                    return true;
                }
                pointerA = pointerA.next;
                pointerB = pointerB.next.next;
            }
        }
        return false;
    }
}
