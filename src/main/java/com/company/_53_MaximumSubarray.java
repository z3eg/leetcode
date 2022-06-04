package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/maximum-subarray/
public class _53_MaximumSubarray {

    //stolen
    public int maxSubArray(int[] nums) {
        int currentSum= 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            currentSum = Math.max(currentSum + nums[i] , nums[i]);
            maxSum = Math.max(currentSum , maxSum);
        }
        return maxSum;
    }

    /*Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
*/

    @Test
    public void test() {
        assertEquals(6,maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        assertEquals(1,maxSubArray(new int[]{1}));
        assertEquals(23,maxSubArray(new int[]{5,4,-1,7,8}));
    }

}
