package com.company;

//https://leetcode.com/problems/merge-nodes-in-between-zeros/
public class _2181_MergeNodesInBetweenZeros {

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode beforeHead = new ListNode(0, head);
        while (head.next!=null) {
            if (head.next.val!=0) {
                head.val+=head.next.val;
                head.next = head.next.next;
            }
            else {
                if (head.next.next==null) {
                    head.next=null;
                    break;
                }
                head = head.next;
            }
        }
        return beforeHead.next;
    }

}
