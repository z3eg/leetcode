package com.company.util;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _1846 {
//    46 / 49 testcases passed
    /*public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int max = 0;
        for (int a : arr) {
            max = Math.max(a, max);
        }
        return Math.min(max, arr.length);
    }*/

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int max = 0;
        for (int a : arr) {
            max = Math.max(a, max);
        }
        return Math.min(max, arr.length);
    }

    @Test
    public void test() {
        assertEquals(2, maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1}));
        assertEquals(3, maximumElementAfterDecrementingAndRearranging(new int[]{100,1,1000}));
        assertEquals(5, maximumElementAfterDecrementingAndRearranging(new int[]{1,2,3,4,5}));
    }
}
