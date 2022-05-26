package com.company;

//https://leetcode.com/problems/remove-duplicates-from-sorted-list-i
public class _82_RemoveDuplicatesfromSortedListII {

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    //0 ms
    public ListNode deleteDuplicates(ListNode head) {
        ListNode beforeFirst = new ListNode(0, head);
        ListNode current = beforeFirst;
        while (current.next!=null && current.next.next != null) {
            int repVal;
            if (current.next.val == current.next.next.val) {
                repVal = current.next.val;
                while (current.next!=null && current.next.val == repVal) {
                    current.next = current.next.next;
                }
            }
            else {
                current = current.next;
            }
        }
        return beforeFirst.next;
    }
}
