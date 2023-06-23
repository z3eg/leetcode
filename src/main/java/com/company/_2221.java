package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*2221. Find Triangular Sum of an Array
        https://leetcode.com/problems/find-triangular-sum-of-an-array/*/
public class _2221 {

    /*Runtime
    85 ms
    Beats
    81.59%*/
    public int triangularSum(int[] nums) {
        if (nums.length==1)
            return nums[0];
        int right = nums.length-1;
        while (right>0) {
            for (int i = 0; i < right; i++) {
                nums[i] = (nums[i]+nums[i+1])%10;
            }
            right--;
        }
        return nums[0];
    }

    @Test
    public void test() {
        assertEquals(0, triangularSum(new int[]{2,6,6,5,5,3,3,8,6,4,3,3,5,1,0,1,3,6,9}));
        assertEquals(8, triangularSum(new int[]{1,2,3,4,5}));
        assertEquals(5, triangularSum(new int[]{5}));
    }
}
