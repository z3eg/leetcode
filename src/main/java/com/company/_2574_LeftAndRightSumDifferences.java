package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

//https://leetcode.com/problems/left-and-right-sum-differences/
public class _2574_LeftAndRightSumDifferences {
    public int[] leftRigthDifference(int[] nums) {
        int numlen = nums.length;
        int[] leftsum = new int[numlen];
        int[] rightsum = new int[numlen];
        for (int i = 1; i < numlen; i++) {
            leftsum[i] = leftsum[i-1]+nums[i-1];
            rightsum[numlen-i-1] = rightsum[numlen-i]+nums[numlen-i];
        }
        for (int i = 0; i < numlen; i++) {
            nums[i] = Math.abs(leftsum[i] - rightsum[i]);
        }
        return nums;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{15,1,11,22}, leftRigthDifference(new int[]{10,4,8,3}));
    }
}
