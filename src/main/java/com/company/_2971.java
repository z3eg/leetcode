package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _2971 {
    /*Wrong Answer
918 / 980 testcases passed*/
    public long largestPerimeter(int[] nums) {
        int totalSum = 0;
        for (int n : nums) {
            totalSum+=n;
        }
        int sidesLeft = nums.length;
        while (sidesLeft > 2) {
            long max = -1;
            int maxPos = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxPos = i;
                }
            }
            totalSum -= max;
            if (max < totalSum)
                return max+totalSum;
            nums[maxPos] = -1;
            sidesLeft--;
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(15, largestPerimeter(new int[]{5,5,5}));
        assertEquals(12, largestPerimeter(new int[]{1,12,1,2,5,50,3}));
        assertEquals(-1, largestPerimeter(new int[]{5,5,50}));
    }
}
