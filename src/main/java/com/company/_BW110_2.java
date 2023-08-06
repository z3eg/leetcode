package com.company;

import com.company.util.list.ListNode;

/*6940. Insert Greatest Common Divisors in Linked List
        https://leetcode.com/contest/biweekly-contest-110/problems/insert-greatest-common-divisors-in-linked-list/*/
public class _BW110_2 {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode headRef = head;
        while (head.next!=null) {
            ListNode gcdNode = new ListNode(gcd(head.val, head.next.val));
            ListNode tmp = head.next;
            head.next = gcdNode;
            gcdNode.next = tmp;
            head = tmp;
        }
        return headRef;
    }

    public int gcd(int x, int y) {
        int max = Math.max(x,y);
        for (int i = max; i > 0; i--) {
            if (x%i==0 && y%i==0)
                return i;
        }
        return 1;
    }
}
