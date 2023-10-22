package com.company;

import com.company.util.list.ListNode;

/*83. Remove Duplicates from Sorted List
        https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/*/
public class _83 {

    /*0ms
    Beats 100.00%of users with Java*/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode headref = head;
        while (head!=null && head.next!=null) {
            while (head.next!=null && head.next.val==head.val)
                head.next = head.next.next;
            head = head.next;
        }
        return headref;
    }
}
