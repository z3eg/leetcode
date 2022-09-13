package com.company;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _1220_CountVowelsPermutation {

//    TLE
    /*private static class Node {
        int val;
        public Node(int val) {
            this.val = val;
        }
    }

    public int countVowelPermutation(int n) {
        Node root = new Node(0);
        add(root, 1, n, 'a');
        add(root, 1, n, 'e');
        add(root, 1, n, 'i');
        add(root, 1, n, 'o');
        add(root, 1, n, 'u');
        return root.val;
    }

    public void add(Node node, int curSize, int reqSize, char lastChar) {
        if (curSize == reqSize) {
            node.val++;
        }
        if (curSize < reqSize) {
            curSize++;
            switch (lastChar) {
                case 'a' -> add(node, curSize, reqSize, 'e');
                case 'i' -> {
                    add(node, curSize, reqSize, 'a');
                    add(node, curSize, reqSize, 'e');
                    add(node, curSize, reqSize, 'o');
                    add(node, curSize, reqSize, 'u');
                }
                case 'e' -> {
                    add(node, curSize, reqSize, 'a');
                    add(node, curSize, reqSize, 'i');
                }
                case 'o' -> {
                    add(node, curSize, reqSize, 'u');
                    add(node, curSize, reqSize, 'i');
                }
                case 'u' -> add(node, curSize, reqSize, 'a');
            }
        }
    }*/

    public int countVowelPermutation(int n) {
        int res = 0;
        res+=add(0, 0, n, 'a');
        res+=add(0, 0, n, 'e');
        res+=add(0, 0, n, 'i');
        res+=add(0, 0, n, 'o');
        res+=add(0, 0, n, 'u');
        return res;
    }

    public int add(int curAmount, int curSize, int reqSize, char lastChar) {
        curSize++;
        if (curSize == reqSize) {
            return ++curAmount;
        }
        if (curSize < reqSize) {
            switch (lastChar) {
                case 'a' -> curAmount+=add(curAmount, curSize, reqSize, 'e');
                case 'i' -> {
                    int tmpCA = curAmount;
                    curAmount+=add(tmpCA, curSize, reqSize, 'a');
                    curAmount+=add(tmpCA, curSize, reqSize, 'e');
                    curAmount+=add(tmpCA, curSize, reqSize, 'o');
                    curAmount+=add(tmpCA, curSize, reqSize, 'u');
                }
                case 'e' -> {
                    int tmpCA = curAmount;
                    curAmount+=add(tmpCA, curSize, reqSize, 'a');
                    curAmount+=add(tmpCA, curSize, reqSize, 'i');
                }
                case 'o' -> {
                    int tmpCA = curAmount;
                    curAmount+=add(tmpCA, curSize, reqSize, 'u');
                    curAmount+=add(tmpCA, curSize, reqSize, 'i');
                }
                case 'u' -> curAmount+=add(curAmount, curSize, reqSize, 'a');
            }
        }
        return curAmount;
    }

    /*Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
    Each vowel 'a' may only be followed by an 'e'.
    Each vowel 'e' may only be followed by an 'a' or an 'i'.
    Each vowel 'i' may not be followed by another 'i'.
    Each vowel 'o' may only be followed by an 'i' or a 'u'.
    Each vowel 'u' may only be followed by an 'a'.*/

    @Test
    public void test() {
        assertEquals(10, countVowelPermutation(2));
        assertEquals(5, countVowelPermutation(1));
    }

    /*Example 1:

    Input: n = 1
    Output: 5
    Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
    Example 2:

    Input: n = 2
    Output: 10
    Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".*/

}
