package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _713 {

    /*Wrong Answer
24 / 98 testcases passed*/
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int window = nums.length;
        int counter = 0;
        while (window > 0) {
            int curProduct = 1;
            for (int i = 0; i < window; i++) {
                curProduct*=nums[i];
            }
            if (curProduct<k)
                counter++;
            //moving window
            for (int i = window; i < nums.length; i++) {
                curProduct/=nums[i-window];
                curProduct*=nums[i];
                if (curProduct<k)
                    counter++;
            }
            window--;
        }
        return counter;
    }

    @Test
    public void test() {
        assertEquals(8, numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
        assertEquals(0, numSubarrayProductLessThanK(new int[]{1,2,3}, 0));
    }
}
