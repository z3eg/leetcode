package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _2958 {

    //shrinking sliding window going back and forth?
    public int maxSubarrayLength(int[] nums, int k) {
        return 0;
    }

    @Test
    public void test() {
        assertEquals(6, maxSubarrayLength(new int[]{1,2,3,1,2,3,1,21,2,3,1,2,3,1,2}, 2));
        assertEquals(2, maxSubarrayLength(new int[]{1,2,1,2,1,2,1,2}, 2));
        assertEquals(2, maxSubarrayLength(new int[]{5,5,5,5,5,5,5}, 2));
    }
}
