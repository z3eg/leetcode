package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class _1685 {
    /*Time Limit Exceeded
53 / 59 testcases passed
*/
    /*public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int curSum = 0;
            for (int j = 0; j < nums.length; j++) {
                curSum += Math.abs(nums[i]-nums[j]);
            }
            res[i] = curSum;
        }
        return res;
    }*/

    /*3
    ms
    Beats
    99.36%
    of users with Java*/
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] res = new int[nums.length];
        int totSum = 0;
        for (int n : nums)
            totSum+=n;
        int rSum = totSum;
        int lSum = 0;
        for (int i = 0; i < nums.length; i++) {
            res[i] = rSum-(nums.length-i)*nums[i] + i*nums[i]-lSum;
            rSum-=nums[i];
            lSum+=nums[i];
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{4,3,5}, getSumAbsoluteDifferences(new int[]{2,3,5}));
        assertArrayEquals(new int[]{24,15,13,15,21}, getSumAbsoluteDifferences(new int[]{1,4,6,8,10}));
//        assertArrayEquals(new int[]{}, getSumAbsoluteDifferences(new int[]{}));
    }
}
