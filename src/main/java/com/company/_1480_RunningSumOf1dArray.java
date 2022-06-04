package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

//https://leetcode.com/problems/running-sum-of-1d-array/
public class _1480_RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i]=result[i-1]+nums[i];
        }
        return result;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1,3,6,10}, runningSum(new int[]{1,2,3,4}));
        assertArrayEquals(new int[]{1,2,3,4,5}, runningSum(new int[]{1,1,1,1,1}));
        assertArrayEquals(new int[]{3,4,6,16,17}, runningSum(new int[]{3,1,2,10,1}));
    }

    /*Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
Example 2:

Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
Example 3:

Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]*/
}
