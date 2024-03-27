package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _713 {

    /*Wrong Answer
24 / 98 testcases passed*/
    /*public int numSubarrayProductLessThanK(int[] nums, int k) {
        int window = nums.length;
        int counter = 0;
        while (window > 0) {
            int curProduct = 1;
            for (int i = 0; i < window; i++) {
                curProduct*=nums[i];
            }
            if (curProduct<k)
                counter++;
            //moving window
            for (int i = window; i < nums.length; i++) {
                curProduct/=nums[i-window];
                curProduct*=nums[i];
                if (curProduct<k)
                    counter++;
            }
            window--;
        }
        return counter;
    }*/

    /*Wrong Answer
34 / 98 testcases passed*/
    /*public int numSubarrayProductLessThanK(int[] nums, int k) {
        int window = nums.length;
        int counter = 0;
        while (window > 0) {
            long curProduct = 1;
            for (int i = 0; i < window; i++) {
                curProduct*=nums[i];
            }
            if (curProduct<k)
                counter++;
            //moving window
            for (int i = window; i < nums.length; i++) {
                curProduct/=nums[i-window];
                curProduct*=nums[i];
                if (curProduct<k)
                    counter++;
            }
            window--;
        }
        return counter;
    }*/

    /*Time Limit Exceeded
66 / 98 testcases passed*/
    //probs need to DP
    /*public int numSubarrayProductLessThanK(int[] nums, int k) {
        int window = nums.length;
        int counter = 0;
        while (window > 0) {
            double curProduct = 1;
            for (int i = 0; i < window; i++) {
                curProduct*=nums[i];
            }
            if (curProduct<k)
                counter++;
            //moving window
            for (int i = window; i < nums.length; i++) {
                curProduct/=nums[i-window];
                curProduct*=nums[i];
                if (curProduct<k)
                    counter++;
            }
            window--;
        }
        return counter;
    }*/

    /*public int numSubarrayProductLessThanK(int[] nums, int k) {
        double[][] dp = new double[nums.length][nums.length];
        int window = nums.length;
        int counter = 0;
        while (window >= 1) {
            //moving window
            for (int i = window; i < nums.length; i++) {
                double curProduct = dp(i-window, window, dp, nums);
                if (curProduct<k)
                    counter++;
            }
            window--;
        }
        return counter;
    }

    double dp(int start, int end, double[][]dp, int[] nums) {
        double curDp = dp[start][end];
        if (curDp!=0)
            return curDp;
        else {
            if (start==end) {
                dp[start][end] = nums[start];
            }
            else if (end-start==1) {
                dp[start][end] = nums[start]*nums[end];
            }
            else {
                int mid = start + (end - start) / 2;
                dp[start][end] = dp(start, mid, dp, nums)*dp(mid, end, dp, nums);
            }
        }
        return dp[start][end];
    }*/

    //DO SLIDING WINDOW BUT BACK AND FORTH REMOVING AN ELEMENT AS WINDOW SHRINKS (OR ADDING AS IT GROWS)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int window = nums.length;
        int counter = 0;
        while (window > 0) {
            double curProduct = 1;
            for (int i = 0; i < window; i++) {
                curProduct*=nums[i];
            }
            if (curProduct<k)
                counter++;
            //moving window
            for (int i = window; i < nums.length; i++) {
                curProduct/=nums[i-window];
                curProduct*=nums[i];
                if (curProduct<k)
                    counter++;
            }
            window--;
        }
        return counter;
    }


    @Test
    public void test() {
        assertEquals(0, numSubarrayProductLessThanK(new int[]{1,2,3}, 0));
//        assertEquals(18, numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3}, 19));
//        assertEquals(8, numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
}
