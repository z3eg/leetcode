package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _796 {

    /*Wrong Answer
31 / 51 testcases passed*/
    /*class Node {
        char val;
        Node next;

        public Node(char val) {
            this.val = val;
        }
    }

    public boolean rotateString(String s, String goal) {
        Node start = new Node(s.charAt(0));
        Node first = start;
        int len = 1;
        for (int i = 1; i < s.length(); i++) {
            Node next = new Node(s.charAt(i));
            first.next = next;
            first = next;
            len++;
        }
        first.next = start;

        int curLen = 0;
        while (first.val!=goal.charAt(0) && curLen < len) {
            curLen++;
            first = first.next;
        }
        if (curLen == len)
            return false;
        for (int i = 1; i < goal.length(); i++) {
            if (goal.charAt(i)!=first.next.val)
                return false;
            first = first.next;
        }
        return true;
    }
*/

    /*Wrong Answer
    36 / 51 testcases passed*/
    class Node {
        char val;
        Node next;

        public Node(char val) {
            this.val = val;
        }
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        Node start = new Node(s.charAt(0));
        Node first = start;
        int len = 1;
        for (int i = 1; i < s.length(); i++) {
            Node next = new Node(s.charAt(i));
            first.next = next;
            first = next;
            len++;
        }
        first.next = start;

        int curLen = 0;
        while (first.val!=goal.charAt(0) && curLen < len) {
            curLen++;
            first = first.next;
        }
        if (curLen == len)
            return false;
        for (int i = 1; i < goal.length(); i++) {
            if (goal.charAt(i)!=first.next.val)
                return false;
            first = first.next;
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(rotateString("abcde", "cdeab"));
        assertFalse(rotateString("abcde", "abced"));
    }
}
