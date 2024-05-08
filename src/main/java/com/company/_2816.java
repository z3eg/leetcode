package com.company;

import com.company.util.list.ListNode;

import java.math.BigInteger;

public class _2816 {

    public ListNode doubleIt(ListNode head) {
        BigInteger n = BigInteger.valueOf(head.val);
        while (head.next!=null) {
            n = n.multiply(BigInteger.valueOf(10));
            n = n.add(BigInteger.valueOf(head.next.val));
            head = head.next;
        }
        n = n.multiply(BigInteger.valueOf(2));
        BigInteger one = BigInteger.valueOf(1);
        BigInteger ten = BigInteger.valueOf(10);
        ListNode newHead = null;
        while (n.compareTo(one)==1) {
            head = new ListNode(n.mod(ten).intValue());
            head.next = newHead;
            newHead = head;
        }
        return newHead;
    }
}
