package com.company;

import com.company.util.list.ListNode;

public class _21 {
    /*0ms
    Beats 100.00%of users with Java*/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode headRef = head;
        while (!(list1==null && list2==null)) {
            int l1Val = Integer.MAX_VALUE;
            int l2Val = Integer.MAX_VALUE;
            if (list1!=null)
                l1Val = list1.val;
            if (list2!=null)
                l2Val = list2.val;
            if (l1Val < l2Val) {
                head.next = new ListNode(l1Val);
                list1 = list1.next;
            }
            if (l2Val <= l1Val) {
                head.next = new ListNode(l2Val);
                list2 = list2.next;
            }
            head = head.next;
        }
        return headRef.next;
    }
}
