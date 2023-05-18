package com.company.util.list;

import com.company.util.StringToArrayConverter;
import com.company.util.tree.TreeNode;

public class ListBuilder {

    public static ListNode convert(String listString) {
        return buildListFromArray(StringToArrayConverter.convert(listString));
    }

    public static ListNode buildListFromArray(String[] array) {
        ListNode head = new ListNode(Integer.parseInt(array[0]));
        ListNode headPointer = head;
        for (int i = 1; i < array.length; i++) {
            head.next = new ListNode(Integer.parseInt(array[i]));
            head = head.next;
        }
        return headPointer;
    }

}
