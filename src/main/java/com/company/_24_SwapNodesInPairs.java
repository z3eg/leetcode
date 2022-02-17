package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/swap-nodes-in-pairs/
public class _24_SwapNodesInPairs {

     private class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     public ListNode swapPairs(ListNode head) {
          ListNode beforeHead = new ListNode(0, head);
          ListNode current = beforeHead;
          ListNode tmp;
          while (current.next!=null && current.next.next!=null) {
               tmp = current.next.next;
               current.next.next = tmp.next;
               tmp.next = current.next;
               current.next = tmp;
               current = current.next.next;
          }
          return beforeHead.next;
     }

     //build a list and return head
     private ListNode build(int[] arr) {
          if (arr.length < 1) {
               return null;
          }
          ListNode head = new ListNode(arr[0]);
          ListNode cur = head;
          for (int i = 1; i < arr.length; i++) {
               ListNode newNode = new ListNode(arr[i]);
               cur.next = newNode;
               cur = newNode;
          }
          return head;
     }

     private String asString(int[] arr) {
          ListNode head = build(arr);
          return asString(head);
     }

     private String asString(ListNode head) {
          StringBuilder stringBuilder = new StringBuilder();
          while (head!=null) {
               stringBuilder.append(head.val + "->");
               head = head.next;
          }
          return stringBuilder.toString();
     }


     @Test
     public void test() {
//          ListNode list = build(new int[]{1, 2, 3, 4,5,6,7});
          ListNode list = build(new int[]{});
          System.out.println(asString(list));
          ListNode afterSwap = swapPairs(list);
          System.out.println(asString(afterSwap));


          assertEquals(asString(new int[]{2,1,4,3}),asString(swapPairs(build(new int[]{1,2,3,4}))));
          assertEquals(asString(new int[]{}),asString(swapPairs(build(new int[]{}))));
          assertEquals(asString(new int[]{1}),asString(swapPairs(build(new int[]{1}))));
     }

     /*Input: head = [1,2,3,4]
     Output: [2,1,4,3]
     Example 2:

     Input: head = []
     Output: []
     Example 3:

     Input: head = [1]
     Output: [1]*/
}
