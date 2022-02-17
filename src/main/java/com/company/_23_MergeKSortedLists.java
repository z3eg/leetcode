package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Definition for singly-linked list.
 *
 */

//https://leetcode.com/problems/merge-k-sorted-lists/
public class _23_MergeKSortedLists {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //try to do this using priority queue
    public ListNode mergeKLists(ListNode[] lists) {
        //will use zeroNode.next() to get the head of the list
        ListNode zeroNode = new ListNode(0);
        ListNode head = zeroNode;
        PriorityQueue<Integer> pointersQueue = new PriorityQueue<>();
        for (ListNode node: lists) {
            while (node.next!=null) {
                pointersQueue.offer(node.val);
                node = node.next;
            }
        }
        while (!pointersQueue.isEmpty()) {
            head.next = new ListNode(pointersQueue.poll());
            head = head.next;
        }
        return zeroNode.next;
    }

    //doesn't work
    /*public ListNode mergeKLists(ListNode[] lists) {
        LinkedList<ListNode> leftOvers = new LinkedList<>();
        ListNode startingList = lists[0];
        leftOvers.add(lists[0]);
        int min = lists[0].val;
        int secondMostMin = lists[0].val;
        for (int i = 1; i < lists.length; i++) {
            leftOvers.add(lists[i]);
            if (min > lists[i].val) {
                startingList = lists[i];
                secondMostMin = min;
                min = lists[i].val;
            }
        }
        ListNode curNode = startingList;
        //main phase
        while(!leftOvers.isEmpty()) {
            leftOvers.remove(curNode);
            while (curNode.next!=null && curNode.next.val<=secondMostMin) {
                curNode = curNode.next;
            }
            ListNode endOfMain = curNode;
            ListNode startOfTail = curNode.next;
            leftOvers.add(startOfTail);
            //get min among others
            Iterator<ListNode> iterator = leftOvers.iterator();
            ListNode curList;
            min = leftOvers.get(0).val;
            secondMostMin = leftOvers.get(0).val;
            curNode = leftOvers.get(0);
            while (iterator.hasNext()) {
                ListNode next = iterator.next();
                if (min > next.val) {
                    secondMostMin = min;
                    min = next.val;
                    curNode = next;
                }
            }
            endOfMain.next = curNode;
        }
        return startingList;
    }*/

    /*private class ListWrapper {
        public ListNode curNode;
        public boolean isActive;
        public ListNode prevNode;

        public ListWrapper(ListNode curNode) {
            this.curNode = curNode;
            this.isActive = true;
        }

        public int getTail(int stopVal) {
            if (curNode.val == stopVal) {
                return stopVal+1;
            }
            while (curNode!=null && curNode.val <= stopVal) {
                prevNode = curNode;
                curNode = curNode.next;
            }
            if (curNode==null) {
                isActive = false;
            }
            return stopVal;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        LinkedList<ListWrapper> listWrappers = new LinkedList<>();
        ListWrapper minNode = new ListWrapper(lists[0]);
        listWrappers.add(minNode);
        int min = lists[0].val;
        int secondMostMin = min;
        //wrap all lists and mark starting list to iterate
        for (int i = 1; i < lists.length; i++) {
            ListWrapper curListWrapper = new ListWrapper(lists[i]);
            listWrappers.add(curListWrapper);
            if (lists[i].val < min) {
                minNode = curListWrapper;
                secondMostMin = min;
                min = minNode.curNode.val;
            }
        }
        ListNode startNode = minNode.curNode;
        //initiate the main phase
        while (!listWrappers.isEmpty()) {
            min = minNode.getTail(secondMostMin);
//            min = lists[0].val;
            ListNode curEnd = minNode.prevNode;
            secondMostMin = min;
            Iterator<ListWrapper> iterator = listWrappers.iterator();
            while (iterator.hasNext()) {
                ListWrapper curListWrapper = iterator.next();
                if (!curListWrapper.isActive) {
                    iterator.remove();
                }
                else {
                    if (curListWrapper.curNode.val <= min) {
                        minNode = curListWrapper;
                        secondMostMin = min;
                        min = minNode.curNode.val;
                        if (curEnd!=null) {
                            curEnd.next = minNode.curNode;
                        }
                    }
                }
            }
        }
        return startNode;
    }*/

    /*public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> pointersList = new LinkedList<>();
        ListNode firstNode = null;
        ListNode lastNode = firstNode;
        for (int i = 0; i < lists.length; i++) {
            pointersList.add(lists[i]);
        }
        while (!pointersList.isEmpty()) {
            Iterator<ListNode> iterator = pointersList.iterator();
            int min= iterator.next().val;
            ListNode minNode = new ListNode();
            while (iterator.hasNext()) {
                ListNode next = iterator.next();
                int cur = next.val;
                if (cur<min) {
                    min = cur;
                    minNode = next;
                }
            }
            pointersList.remove(minNode);
            if (minNode.next!=null) {
                pointersList.add(minNode.next);
            }
            if (firstNode==null) {
                firstNode = minNode;
                lastNode = minNode;
            }
            else {
                lastNode.next = minNode;
                lastNode = lastNode.next;
            }
        }
        return firstNode;
    }*/

    private ListNode create(List<Integer> list) {
        ListNode last = new ListNode(list.get(list.size()-1));
        ListNode cur = new ListNode();
        for (int i = list.size()-2; i >=0 ; i--) {
            cur = new ListNode(list.get(i),last);
            last = cur;
        }
        return cur;
    }

    private void printListFromNode(ListNode node) {
        ListNode cur = node;
        while (cur!=null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }

    private void printConventionally(ListNode node) {
        System.out.print("[");
        ListNode cur = node;
        while (cur!=null) {
            System.out.print(cur.val + ",");
            cur = cur.next;
        }
        System.out.print("]");
        System.out.println();
    }

    @Test
    public void testListNodes() {
        ListNode list = create(Arrays.asList(1, 4, 5));
        printConventionally(list);
    }

    @Test
    public void test() {
        ListNode[] lists = new ListNode[]{
                create(Arrays.asList(1,4,5)),
                create(Arrays.asList(1,3,4)),
                create(Arrays.asList(2,6)),
        };
        /*assertEquals(printConventionally(create(Arrays.asList(1,1,2,3,4,4,5,6))),
                printConventionally(mergeKLists(lists)));*/
        assertEquals(create(List.of()),mergeKLists(new ListNode[0]));
        assertEquals(create(List.of()),mergeKLists(new ListNode[]{create(List.of())}));

    }

    /*Input: lists = [[1,4,5],[1,3,4],[2,6]]
    Output: [1,1,2,3,4,4,5,6]*/
}
