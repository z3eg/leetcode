package com.company;

import com.company.util.list.ListNode;

import java.util.HashSet;
import java.util.Set;

public class _160 {

    /*5
    ms
            Beats
27.10%
    of users with Java*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> listNodes = new HashSet<>();
        while (headA!=null) {
            listNodes.add(headA);
            headA = headA.next;
        }
        while (!listNodes.contains(headB) && headB!=null) {
            headB = headB.next;
        }
        return headB;
    }
}
