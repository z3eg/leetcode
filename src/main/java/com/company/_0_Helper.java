package com.company;

import org.junit.Test;

import static org.junit.Assert.fail;

public class _0_Helper {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*public ListNode getList(int[] arr) {
        ListNode zero = new ListNode();
        ListNode curNode = new ListNode();
        zero.next = curNode;
        for (int a: arr
             ) {
            curNode.val = a;
            curNode.next = new ListNode();
            curNode = curNode.next;
        }
        return zero.next;
    }*/

    public static ListNode getList(int[] arr) {
        ListNode zero = new ListNode();
        ListNode curNode = zero;
        for (int a: arr
        ) {
            curNode.next = new ListNode(a);
            curNode = curNode.next;
        }
        return zero.next;
    }

    public void assertEquals(ListNode list1, ListNode list2) {
        int counter = 0;
        while (list1.next!=null) {
            if (list1.next.val!=list2.next.val) {
                fail(counter + ":\t" + list1.val + "!=" + list2.val);
            }
        }
        if (list2.next!=null) {
            fail("list2 is longer");
        }
    }

    @Test
    public void test() {
        ListNode list = getList(new int[]{1, 2, 4});
        System.out.println(list);
    }
}
