package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/find-the-pivot-integer/
public class _2485_FindThePivotInteger {
    public int pivotInteger(int n) {
        int[] lSums = new int[n];
        int[] rSums = new int[n];
        int l = 1;
        int r = n;
        int lSum = 0;
        int rSum = 0;
        for (int i = 0; i < n; i++) {
            lSum+=l;
            rSum+=r;
            l++;
            r--;
            lSums[i] = lSum;
            rSums[n-i-1] = rSum;
            if (lSums[i]==rSums[i])
                return i+1;
            if (lSums[n-i-1]==rSums[n-i-1])
                return n-i;
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(6, pivotInteger(8));
        assertEquals(1, pivotInteger(1));
        assertEquals(-1, pivotInteger(4));
    }
}
