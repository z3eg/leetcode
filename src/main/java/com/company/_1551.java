package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*1551. Minimum Operations to Make Array Equal
https://leetcode.com/problems/minimum-operations-to-make-array-equal/*/
public class _1551 {
    /*public int minOperations(int n) {
        int start;
        int end = n-1;
        if (n%2==0) {
            start = 1;
        }
        else {
            start = 2;
        }
        return (n/2*(start+end))/2;
    }*/

    public int minOperations(int n) {
        return (n/2*(n%2+n))/2;
    }

    @Test
    public void test() {
        assertEquals(2, minOperations(3));
        assertEquals(9, minOperations(6));
    }
}
