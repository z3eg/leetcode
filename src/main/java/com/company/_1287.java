package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1287 {

    /*1
    ms
            Beats
64.44%
    of users with Java*/
    public int findSpecialInteger(int[] arr) {
        int threshold = arr.length/4;
        int[] freqs = new int[100_001];
        for (int n : arr) {
            freqs[n]++;
            if (freqs[n] > threshold)
                return n;
        }
        return 0;
    }

    @Test
    public void test() {
        assertEquals(1, findSpecialInteger(new int[]{1}));
        assertEquals(6, findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
        assertEquals(1, findSpecialInteger(new int[]{1,1}));
    }
}
