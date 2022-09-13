package com.company;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _234_PalindromeLinkedList {

    private class ListNode {
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

    /*public boolean isPalindrome(ListNode head) {
        LinkedList<Integer> integers = new LinkedList<>();
        while (head!=null) {
            integers.add(head.val);
            head = head.next;
        }
        int size = integers.size();
        int halfSize = size / 2;
        int sizeMin1 = size - 1;
        for (int i = 0; i < halfSize; i++) {
            if ((integers.get(i)!= integers.get(sizeMin1 - i)))
                return false;
        }
        return true;
    }*/

    public boolean isPalindrome(ListNode head) {
        int len = countNodes(head);
        int halflen = len / 2;
        int num = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (num< halflen) {
            stack.push(head.val);
            num++;
            head = head.next;
        }
        if (len%2==1)
            head = head.next;
        while (head!=null) {
            Integer pop = stack.pop();
            if (pop!=head.val)
                return false;
            head = head.next;
        }
        return true;
    }

    private int countNodes(ListNode head) {
        int res = 1;
        while (head.next!=null) {
            res++;
            head = head.next;
        }
        return res;
    }

    private ListNode initList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode headRef = head;
        for (int i = 1; i < arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
        return headRef;
    }

    @Test
    public void test() {
//        assertTrue(isPalindrome(initList(new int[]{1,2,3,2,1})));
        assertTrue(isPalindrome(initList(new int[]{1,2,2,1})));
        assertTrue(isPalindrome(initList(new int[]{1})));
        assertFalse(isPalindrome(initList(new int[]{1,2})));
    }
}
