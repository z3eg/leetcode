package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _643 {

    /*5
    ms
            Beats
39.32%
    of users with Java*/
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        double curSum = 0;
        for (int i = 0; i < k; i++) {
            curSum+=nums[i];
        }
        max = Math.max(max, curSum/k);
        for (int i = 0; i < nums.length - k; i++) {
            curSum-=nums[i];
            curSum+=nums[i+k];
            max = Math.max(max, curSum/k);
        }
        return max;
    }

    @Test
    public void test() {
        assertEquals(12.75, findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        assertEquals(5, findMaxAverage(new int[]{5}, 1));
    }
}
