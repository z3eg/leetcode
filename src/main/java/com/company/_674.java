package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _674 {

    /*Wrong Answer
25 / 35 testcases passed*/
    /*public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[dp.length-1] = 0;
        int res = 1;
        for (int i = dp.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                dp[i]=dp[i+1]+1;
                res = Math.max(res, dp[i]);
            }
            else {
                dp[i] = 1;
            }
        }
        return res;
    }*/

    /*2
    ms
            Beats
45.22%
    of users with Java*/
    /*public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[dp.length-1] = 1;
        int res = 1;
        for (int i = dp.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                dp[i]=dp[i+1]+1;
                res = Math.max(res, dp[i]);
            }
            else {
                dp[i] = 1;
            }
        }
        return res;
    }*/

    /*2
    ms
            Beats
45.22%
    of users with Java*/
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[dp.length-1] = 1;
        int res = 1;
        for (int i = dp.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                dp[i]=dp[i+1]+1;
            }
            else {
                res = Math.max(res, dp[i+1]);
                dp[i] = 1;
            }
        }
        res = Math.max(res, dp[0]);
        return res;
    }

    @Test
    public void test() {
        assertEquals(4, findLengthOfLCIS(new int[]{1,3,5,7}));
    }

}
