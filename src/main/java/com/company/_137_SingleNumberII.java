package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _137_SingleNumberII {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int num: nums) {
            sum+=num;
        }
        return sum%3;
    }

    @Test
    public void test() {
        assertEquals(3, singleNumber(new int[]{2,2,3,2}));
        assertEquals(99, singleNumber(new int[]{0,1,0,1,0,1,99}));
    }
}
