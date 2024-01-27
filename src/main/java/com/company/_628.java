package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _628 {
    /*Time Limit Exceeded
71 / 92 testcases passed*/
    /*public int maximumProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    max = Math.max(max, nums[i]*nums[j]*nums[k]);
                }
            }
        }
        return max;
    }*/

    /*Wrong Answer
    90 / 92 testcases passed*/
    /*public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length-1]*Math.max(nums[nums.length-2]*nums[nums.length-3],nums[0]*nums[1]);
    }*/

    /*11
    ms
            Beats
79.84%
    of users with Java*/
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n-1]*nums[n-2]*nums[n-3],nums[0]*nums[1]*nums[n-1]);
    }

    @Test
    public void test() {
        assertEquals(60, maximumProduct(new int[]{-5,-4,0,1,2,3}));
        assertEquals(6, maximumProduct(new int[]{0,1,2,3}));
        assertEquals(0, maximumProduct(new int[]{0,-1,-2,-3}));
        assertEquals(6, maximumProduct(new int[]{1,2,3}));
        assertEquals(24, maximumProduct(new int[]{1,2,3,4}));
        assertEquals(-6, maximumProduct(new int[]{-1,-2,-3}));
    }
}
