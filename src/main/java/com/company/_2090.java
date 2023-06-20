package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/*2090. K Radius Subarray Averages
        https://leetcode.com/problems/k-radius-subarray-averages/*/
public class _2090 {
    /*Runtime
    10 ms
    Beats
    91.38%*/
    public int[] getAverages(int[] nums, int k) {
        if (k==0)
            return nums;
        int numLen = nums.length;
        if (k > numLen/2 || (k==numLen/2 && numLen%2==0)) {
            for (int i = 0; i < numLen; i++)
                nums[i] = -1;
            return nums;
        }
        long curSum = 0;
        int[] res = new int[numLen];
        for (int i = 0; i < numLen; i++) {
            curSum+=nums[i];
            if (i<k)
                res[i]=-1;
            if (i>numLen-k-1)
                res[i]=-1;
            if (i>=k*2) {
                res[i-k] = (int)(curSum/(k*2+1));
                curSum-=nums[i-k*2];
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{-1,-1,-1,5,-1,-1,-1}, getAverages(new int[]{7,4,3,9,1,8,5}, 3));
        assertArrayEquals(new int[]{-1,-1,-1,-1,-1}, getAverages(new int[]{7,4,3,5,2}, 3));
        assertArrayEquals(new int[]{-1,-1,-1,-1,-1,-1}, getAverages(new int[]{7,4,3,8,5,2}, 3));
        assertArrayEquals(new int[]{-1,-1,-1,5,4,-1,-1,-1}, getAverages(new int[]{7,4,3,9,1,8,5,2}, 3));
        assertArrayEquals(new int[]{-1,-1,-1,5,4,4,-1,-1,-1}, getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 3));
        assertArrayEquals(new int[]{10000}, getAverages(new int[]{10000}, 0));
        assertArrayEquals(new int[]{-1}, getAverages(new int[]{8}, 100000));
    }
}
