package com.company;

import org.junit.Test;

import static com.company._0_Helper.*;

//TODO finish this
//https://leetcode.com/problems/merge-two-sorted-lists/
public class _21_MergeTwoSortedLists {


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node1 = list1.next;
        ListNode node2 = list2.next;
        ListNode head = node2;
        while (node1!=null) {
            //find insertion point in list 2
            while (node1.val<=node2.val) {
                node2=node2.next;
            }
            //found
            //find insertion part length
            ListNode curHead = node1;
            while (node1.val < node2.next.val) {
                node1 = node1.next;
            }
            //found
            //do the insertion
            ListNode tmp = node2.next;
            node2.next = curHead;
            curHead = node1.next;
            node1.next = tmp;
            node1 = curHead;
        }
        return node2;
    }

    @Test
    public void test() {
//        assertEquals(getList(new int[]{1,1,2,3,4,4}),mergeTwoLists(getList(new int[]{1,2,4}),getList(new int[]{1,3,4})));
    }



}
