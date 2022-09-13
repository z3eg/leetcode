package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

//https://leetcode.com/problems/concatenation-of-array/
public class _1929_ConcatenationOfArray {

    public int[] getConcatenation(int[] nums) {
        int[] ints = new int[nums.length * 2];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = nums[i%nums.length];
        }
        return ints;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1,2,1,1,2,1},getConcatenation(new int[]{1,2,1}));
        assertArrayEquals(new int[]{1,3,2,1,1,3,2,1},getConcatenation(new int[]{1,3,2,1}));

    }

    /*Example 1:

    Input: nums = [1,2,1]
    Output: [1,2,1,1,2,1]
    Explanation: The array ans is formed as follows:
            - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
            - ans = [1,2,1,1,2,1]
    Example 2:

    Input: nums = [1,3,2,1]
    Output: [1,3,2,1,1,3,2,1]
    Explanation: The array ans is formed as follows:
            - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
            - ans = [1,3,2,1,1,3,2,1]*/
}
