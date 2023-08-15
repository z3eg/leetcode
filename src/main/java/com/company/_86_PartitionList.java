package com.company;

import com.company.util.list.ListNode;
import org.junit.jupiter.api.Test;
import scala.util.parsing.combinator.testing.Str;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/partition-list/
public class _86_PartitionList {

    /*-ms
    Beats 100.00%of users with Java*/
    public ListNode partition(ListNode head, int x) {
        if (head==null)
            return head;
        if (head.next==null)
            return head;
        ListNode beforeHead = new ListNode();
        beforeHead.next = head;
        ListNode xNode = head;
        while (xNode.val<x) {
            xNode = xNode.next;
            if (xNode == null)
                return head;
        }
        ListNode prev = xNode;
        ListNode p = prev.next;
        while (p!=null) {
            if (p.val < x) {
                prev.next = p.next;
                ListNode p1 = beforeHead;
                while (p1.next!=xNode && p1.next.val<=x)
                    p1 = p1.next;
                p.next = p1.next;
                p1.next = p;
                prev = xNode;
                p = prev.next;
            }
            else {
                p = p.next;
                prev = prev.next;
            }
        }
        return beforeHead.next;
    }

    String toString(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head!=null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
//        1,4,3,2,5,2], x = 3
        ListNode head;
        String stringRep;

        head = new ListNode(3);
        head.next= new ListNode(1);
        head.next.next= new ListNode(2);
        head = partition(head, 3);
        stringRep = toString(head);
        System.out.println(stringRep);
        assertEquals("123", stringRep);

        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next= new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next= new ListNode(2);
        head = partition(head, 3);
        stringRep = toString(head);
        System.out.println(stringRep);
        assertEquals("122435", stringRep);

        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next= new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next= new ListNode(2);
        head = partition(head, -3);
        stringRep = toString(head);
        System.out.println(stringRep);
        assertEquals("143252", stringRep);

        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next= new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next= new ListNode(2);
        head = partition(head, 8);
        stringRep = toString(head);
        System.out.println(stringRep);
        assertEquals("143252", stringRep);

        head = new ListNode(2);
        head.next= new ListNode(1);
        head = partition(head, 2);
        stringRep = toString(head);
        System.out.println(stringRep);
        assertEquals("12", stringRep);

        head = null;
        stringRep = toString(head);
        System.out.println(stringRep);
        assertEquals("", stringRep);

        head = new ListNode(1);
        head = partition(head, 2);
        stringRep = toString(head);
        System.out.println(stringRep);
        assertEquals("1", stringRep);

        head = new ListNode(1);
        head = partition(head, -2);
        stringRep = toString(head);
        System.out.println(stringRep);
        assertEquals("1", stringRep);
    }
}
