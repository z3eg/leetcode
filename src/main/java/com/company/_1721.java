package com.company;

import com.company.util.list.ListBuilder;
import com.company.util.list.ListNode;
import org.junit.Test;

/*https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
1721. Swapping Nodes in a Linked List*/
public class _1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode headPointer = head;
        int distFromHead = k-1;
        while (distFromHead>0) {
            distFromHead--;
            head = head.next;
        }
        ListNode kthFromStart = head;
        ListNode kthFromEnd = headPointer;
        while (head.next!=null) {
            kthFromEnd = kthFromEnd.next;
            head = head.next;
        }
        int tmp = kthFromStart.val;
        kthFromStart.val = kthFromEnd.val;
        kthFromEnd.val = tmp;
        return headPointer;
    }

    @Test
    public void test() {
        swapNodes(ListBuilder.convert("1,2,3,4,5"), 2);
    }
}
