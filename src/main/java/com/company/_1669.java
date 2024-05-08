package com.company;

import com.company.util.list.ListNode;

public class _1669 {

    /*1
    ms
    Beats
    100.00%
    of users with Java*/
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        int counter = 0;
        ListNode from = head;
        while (counter <= b) {
            if (counter == a-1) {
                from = head;
            }
            counter++;
            head = head.next;
        }
        ListNode list2Head = list2;
        while (list2.next!=null)
            list2 = list2.next;
        from.next = list2Head;
        list2.next = head;
        return list1;
    }
}
