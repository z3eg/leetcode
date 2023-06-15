package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*2733. Neither Minimum nor Maximum
        https://leetcode.com/problems/neither-minimum-nor-maximum/*/
public class _2733 {

    /*Runtime
    7 ms
    Beats
    100%*/
    public int findNonMinOrMax(int[] nums) {
        if (nums.length < 3)
            return -1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int n: nums) {
                if (n < max && n > min)
                    return n;
                if (n > max) {
                    changed = true;
                    max = n;
                }
                if (n < min) {
                    changed = true;
                    min = n;
                }
            }
        }
        return -1;
    }

    //these tests are wrong since it's any number of the array
    /*@Test
    public void test() {
        assertEquals(2, findNonMinOrMax(new int[]{3,2,1,4}));
        assertEquals(-1, findNonMinOrMax(new int[]{1,2}));
        assertEquals(2, findNonMinOrMax(new int[]{2,1,3}));
    }*/
}
