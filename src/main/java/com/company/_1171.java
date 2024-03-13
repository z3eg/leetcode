package com.company;

import com.company.util.list.ListNode;

import java.util.HashMap;

public class _1171 {

    /*Wrong Answer
10 / 105 testcases passed*/
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode preHead = new ListNode();
        ListNode preHead2 = new ListNode();
        preHead.next = head;
        preHead2.next = head;
        int prefSum = 0;
        HashMap<Integer, ListNode> occurMap = new HashMap<>();
        while (preHead.next!=null) {
            prefSum+=preHead.next.val;
            if (occurMap.containsKey(prefSum)) {
                ListNode nodeToDeleteFrom = occurMap.get(prefSum);
                nodeToDeleteFrom.next = preHead.next;
                int tmpSum = prefSum;
                while (occurMap.containsKey(tmpSum)) {
                    ListNode listNode = occurMap.get(tmpSum);
                    occurMap.remove(tmpSum);
                    tmpSum-=listNode.val;
                }
            }
            else {
                occurMap.put(prefSum, preHead);
            }
            preHead = preHead.next;
        }
        return preHead2.next;
    }
}
