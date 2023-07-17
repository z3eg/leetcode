package com.company;

import com.company.util.list.ListBuilder;
import com.company.util.list.ListNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

//https://leetcode.com/problems/add-two-numbers-ii/
public class _445_AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        HashMap<ListNode, ListNode> nodeToPrev1 = new HashMap<>();
        HashMap<ListNode, ListNode> nodeToPrev2 = new HashMap<>();
        while (l1!=null) {
            nodeToPrev1.put(l1.next, l1);
            l1 = l1.next;
        }
        while (l2!=null) {
            nodeToPrev2.put(l2.next, l2);
            l2 = l2.next;
        }
        int overhead = 0;
        ListNode l3Next = null;
        ListNode l3 = null;
        while (l1!=l1Head || l2!=l2Head || overhead!=0) {
            int sum = ((l1==null)?0:l1.val)+((l2==null)?0:l2.val) + overhead;
            int l3Val = sum%10;
            overhead = sum/10;
            l3 = new ListNode(l3Val);
            l3.next = l3Next;
            l1 = nodeToPrev1.get(l1);
            l2 = nodeToPrev2.get(l2);
            l3Next = l3;
        }
        return l3;
    }

    @Test
    public void test() {
        addTwoNumbers(ListBuilder.convert("7,2,4,3"),ListBuilder.convert("5,6,4"));
    }
}
