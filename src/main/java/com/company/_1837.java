package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//1837. Sum of Digits in Base K
//https://leetcode.com/problems/sum-of-digits-in-base-k/
public class _1837 {
    /*Runtime
    0 ms
    Beats
    100%*/
    public int sumBase(int n, int k) {
        int sum = 0;
        while (n>=1) {
            sum+=n%k;
            n/=k;
        }
        return sum;
    }

    @Test
    public void test() {
        assertEquals(2, sumBase(68, 2));
        assertEquals(3, sumBase(42, 2));
        assertEquals(1, sumBase(10, 10));
        assertEquals(9, sumBase(34, 6));
    }
}
