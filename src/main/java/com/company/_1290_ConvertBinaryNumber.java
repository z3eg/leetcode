package com.company;

import org.junit.Test;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
public class _1290_ConvertBinaryNumber {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

   /* public int getDecimalValue(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head!=null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        String s = stringBuilder.toString();
        return Integer.parseInt(s);
    }*/

    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head!=null) {
            res*=2;
            res+=head.val;
            head=head.next;
        }
        return res;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        assertEquals(5, getDecimalValue(head));
    }


}
