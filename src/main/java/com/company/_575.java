package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _575 {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        return Math.min(n/2, candyType.length);
    }

    @Test
    public void test() {
        assertEquals(3, distributeCandies(new int[]{1,1,2,2,3,3}));
        assertEquals(2, distributeCandies(new int[]{1,1,2,3}));
        assertEquals(1, distributeCandies(new int[]{6,6,6,6}));
    }
}
