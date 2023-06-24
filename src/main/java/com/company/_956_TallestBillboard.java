package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/tallest-billboard/
public class _956_TallestBillboard {
    //we don't have to use all the rods
    public int tallestBillboard(int[] rods) {
        return 0;
    }

    @Test
    public void test() {
        assertEquals(6, tallestBillboard(new int[]{1,2,3,6}));
        assertEquals(6, tallestBillboard(new int[]{1,2,3,4,5,6}));
        assertEquals(6, tallestBillboard(new int[]{1,2}));
    }
}
