package com.company;

import com.company.util.list.ListNode;

//https://leetcode.com/problems/delete-node-in-a-linked-list/
public class _237 {
    /*Runtime
    0 ms
    Beats
    100%*/
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
