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

    //TLE 5 / 43 testcases passed
    /*public int countVowelPermutation(int n) {
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
    }*/

    /*Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
    Each vowel 'a' may only be followed by an 'e'.
    Each vowel 'e' may only be followed by an 'a' or an 'i'.
    Each vowel 'i' may not be followed by another 'i'.
    Each vowel 'o' may only be followed by an 'i' or a 'u'.
    Each vowel 'u' may only be followed by an 'a'.*/

    /*19ms
    Beats 42.57%of users with Java*/
    public int countVowelPermutation(int n) {
        long[][] dp = new long[n+1][5];
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }
        long res = 0L;
        for (int i = 0; i < 5; i++) {
            res+=dp(n, i, dp);
        }
        return (int) (res%1_000_000_007);
    }

     int[] idx(int c) {
        return switch(c) {
            case 0 -> new int[]{1}; //a->e
            case 1 -> new int[]{0,2}; //e->a,i
            case 2 -> new int[]{0,1,3,4}; //i->a,e,o,u
            case 3 -> new int[]{2,4}; //o->i,u
            case 4 -> new int[]{0};
            default -> null;
        };
    }

    long dp(int length, int c, long[][] dp) {
        if (dp[length][c]!=0)
            return dp[length][c];
        int[] followers = idx(c);
        long curDP = 0;
        for (int f : followers)
            curDP +=dp(length-1,f,dp);
        dp[length][c] = curDP;
        return curDP % 1_000_000_007;
    }

    @Test
    public void test() {
        assertEquals(18208803, countVowelPermutation(144));
        assertEquals(10, countVowelPermutation(2));
        assertEquals(5, countVowelPermutation(1));
    }

}
