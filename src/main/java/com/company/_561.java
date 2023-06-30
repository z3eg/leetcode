package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/*561. Array Partition
        https://leetcode.com/problems/array-partition/*/
public class _561 {
    /*Runtime
    13 ms
    Beats
    95.41%*/
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int numLen = nums.length;
        int res = 0;
        for (int i = 0; i < numLen; i+=2) {
            res+=nums[i];
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(4, arrayPairSum(new int[]{1,4,3,2}));
        assertEquals(9, arrayPairSum(new int[]{6,2,6,5,1,2}));
    }
}
