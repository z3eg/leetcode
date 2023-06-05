package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import scala.collection.immutable.RedBlackTree;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class _703_KthLargestElementInAStream {


    /*Runtime
        355 ms
        Beats
        7.65%*/
    /*class KthLargest {

        class Node {
            int val;
            Node next;
            Node prev;

            public Node(int val) {
                this.val = val;
            }
        }

        Node preHead;
        int k;
        Node kthLargestNode;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            preHead = new Node(10000000);
            for (int num : nums) {
                insertNode(num, preHead);
            }
        }

        public int add(int val) {
            if (kthLargestNode!=null && val <= kthLargestNode.val)
                return kthLargestNode.val;
            int curIndex = insertNode(val, preHead);
            if (kthLargestNode == null) {
                kthLargestNode = preHead.next;
                for (int i = 1; i < k; i++) {
                    this.kthLargestNode = kthLargestNode.next;
                }
                return kthLargestNode.val;
            }
            if (curIndex <= k) {
                kthLargestNode = kthLargestNode.prev;
            }
            return kthLargestNode.val;
        }

        private int insertNode(int val, Node head) {
            int curIndex = 1;
            while (head.next!=null && head.next.val > val) {
                head = head.next;
                curIndex++;
            }
            Node tempNext = head.next;
            Node newNode = new Node(val);
            head.next = newNode;
            newNode.next = tempNext;
            if (tempNext!=null)
                tempNext.prev = newNode;
            newNode.prev = head;
            return curIndex;
        }
    }*/

    /*class KthLargest {

        public KthLargest(int k, int[] nums) {

        }

        public int add(int val) {

        }

    }*/

    /*class KthLargest {

        List<Integer> list;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k-1;
            Arrays.sort(nums);
            list = new LinkedList<>();
            for (int i = nums.length-1; i >= 0; i--) {
                list.add(nums[i]);
            }
        }

        public int add(int val) {
            if (list.isEmpty()) {
                list.add(val);
                return val;
            }
            if (list.size()>k) {
                Integer kthLargest = list.get(k);
                if (val < kthLargest)
                    return kthLargest;
            }
            //find position to add val with binary search
            int pos = findPos(list, 0, k, val);
            list.add(pos, val);
            return list.get(k);
        }

        private int findPos(List<Integer> list, int begin, int end, int num) {
            if (Math.abs(begin-end)<2)
                return list.get(begin)<num?begin:end;
            int mid = (end+begin)/2;
            Integer midNum = list.get(mid);
            if (midNum == num)
                return mid;
            if (midNum < num)
                return findPos(list, begin, mid, num);
            return findPos(list, mid, end, num);
        }
    }*/

    /*Runtime
    1411 ms
                Beats
    5.25%*/
    /*class KthLargest {

        Map<Integer,Integer> map;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            map = new TreeMap<>(Collections.reverseOrder());
            for (int n : nums) {
                Integer nVal = map.get(n);
                map.put(n, nVal==null?1:nVal+1);
            }
        }

        public int add(int val) {
            Integer nVal = map.get(val);
            map.put(val, nVal==null?1:nVal+1);
            int sum = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                sum+=entry.getValue();
                if (sum>=k)
                    return entry.getKey();
            }
            return val;
        }

    }*/

    class KthLargest {

        PriorityQueue<Integer> priorityQueue;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k=k;
            priorityQueue = new PriorityQueue<>(k);
            for (int val : nums) {
                priorityQueue.offer(val);
            }
            while (priorityQueue.size()>k) {
                priorityQueue.poll();
            }
        }

        public int add(int val) {
            priorityQueue.offer(val);
            if (priorityQueue.size()>k) {
                priorityQueue.poll();
            }
            return priorityQueue.peek();
        }

    }

    @Test
    public void test() {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        Assertions.assertEquals(4, kthLargest.add(3));
        Assertions.assertEquals(5, kthLargest.add(5));
        Assertions.assertEquals(5, kthLargest.add(10));
        Assertions.assertEquals(8, kthLargest.add(9));
        Assertions.assertEquals(8, kthLargest.add(4));

        kthLargest = new KthLargest(2, new int[]{0});
        Assertions.assertEquals(-1, kthLargest.add(-1));
        Assertions.assertEquals(0, kthLargest.add(1));
        Assertions.assertEquals(0, kthLargest.add(-2));
        Assertions.assertEquals(0, kthLargest.add(-4));
        Assertions.assertEquals(1, kthLargest.add(3));

        kthLargest = new KthLargest(1, new int[]{-2});
        Assertions.assertEquals(-2, kthLargest.add(-3));
        Assertions.assertEquals(0, kthLargest.add(0));
        Assertions.assertEquals(2, kthLargest.add(2));
        Assertions.assertEquals(2, kthLargest.add(-1));
        Assertions.assertEquals(4, kthLargest.add(4));



        kthLargest = new KthLargest(1, new int[]{});
        Assertions.assertEquals(-3, kthLargest.add(-3));
        Assertions.assertEquals(-2, kthLargest.add(-2));
        Assertions.assertEquals(-2, kthLargest.add(-4));
        Assertions.assertEquals(0, kthLargest.add(0));
        Assertions.assertEquals(4, kthLargest.add(4));
    }
}
