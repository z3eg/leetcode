package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/number-of-good-pairs/
public class _1512_NumberOfGoodPairs {
    /*1ms
    Beats 86.48%of users with Java*/
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (nums[i]==nums[j])
                    res++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(4, numIdenticalPairs(new int[]{1,2,3,1,1,3}));
        assertEquals(6, numIdenticalPairs(new int[]{1,1,1,1}));
        assertEquals(0, numIdenticalPairs(new int[]{1,2,3}));
    }

    /*Example 1:

    Input: nums = [1,2,3,1,1,3]
    Output: 4
    Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
            Example 2:

    Input: nums = [1,1,1,1]
    Output: 6
    Explanation: Each pair in the array are good.
            Example 3:

    Input: nums = [1,2,3]
    Output: 0*/
}
