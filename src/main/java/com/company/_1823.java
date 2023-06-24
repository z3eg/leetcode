package com.company;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/*1823. Find the Winner of the Circular Game
        https://leetcode.com/problems/find-the-winner-of-the-circular-game/*/
public class _1823 {
    /*Runtime
    3 ms
    Beats
    55.91%*/
    /*public int findTheWinner(int n, int k) {
        LinkedList<Integer> friends = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            friends.add(i+1);
        }
        int curPos = 0;
        while (friends.size()>1) {
            curPos+=(k-1);
            curPos%=friends.size();
            friends.remove(curPos);
        }
        return friends.get(0);
    }*/

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public int findTheWinner(int n, int k) {
        Node first = new Node(1);
        Node cur = first;
        for (int i = 1; i < n; i++) {
            Node newNode = new Node(i+1);
            cur.next = newNode;
            cur = newNode;
        }
        cur.next = first;
        cur = first;
        while (cur.next!= cur) {
            for (int i = 1; i < k-1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return cur.val;
    }

    @Test
    public void test() {
        assertEquals(3, findTheWinner(5,2));
        assertEquals(1, findTheWinner(6,5));
    }
}
