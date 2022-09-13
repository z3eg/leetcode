package com.company;

import org.junit.Test;

//https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
public class _2006_CountNumberofPairsWithAbsoluteDifferenceK {

    //TODO optimize
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (Math.abs(nums[i]-nums[j])==k)
                    res++;
            }
        }
        return res;
    }

    @Test
    public void test() {

    }
}
