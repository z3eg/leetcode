package com.company;

import com.company.util.list.ListNode;

import java.util.LinkedList;

/*https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
2130. Maximum Twin Sum of a Linked List*/
public class _2130 {

    //TLE
    /*public int pairSum(ListNode head) {
        LinkedList<Integer> integers = new LinkedList<>();
        while (head!=null) {
            integers.add(head.val);
            head = head.next;
        }
        int size = integers.size();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size/2; i++) {
            max = Math.max(max, integers.get(i)+integers.get(size-1-i));
        }
        return max;
    }*/

    public int pairSum(ListNode head) {
        int[] ints = new int[100000];
        int counter = 0;
        while (head!=null) {
            ints[counter]=head.val;
            ints[counter+1] = head.next.val;
            head = head.next.next;
            counter+=2;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < counter/2; i++) {
            max = Math.max(max, ints[i]+ints[counter-i-1]);
        }
        return max;
    }

}
