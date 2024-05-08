package com.company;

import org.apache.commons.math3.stat.inference.GTest;
import org.junit.jupiter.api.Test;
import scala.Int;

import static org.junit.Assert.assertEquals;

/*1425. Constrained Subsequence Sum
        https://leetcode.com/problems/constrained-subsequence-sum/description/?envType=daily-question&envId=2023-10-21*/
public class _1425 {
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dpLeft = new int[nums.length];
        dpLeft[0] = nums[0];
        int[] dpRight = new int[nums.length];
        dpRight[dpRight.length-1] = nums[dpRight.length-1];
        int[] maxDp = {nums[0]};
        dpLeft(dpLeft.length-1, dpLeft,k,nums,maxDp);
        dpRight(0, dpRight, k, nums);
        return maxDp[0];
    }

    int dpLeft(int pos, int[]dp, int k, int[] nums, int[]maxDP) {
        if (pos==0)
            return dp[0];
        int maxLeftDP = dpLeft(pos-1, dp, k, nums, maxDP);
        for (int i = pos-2; i >= 0 && i>=pos-k; i--) {
            maxLeftDP = Math.max(maxLeftDP, dpLeft(i, dp, k, nums, maxDP));
        }
        dp[pos] = nums[pos]+maxLeftDP;
        maxDP[0] = Math.max(maxDP[0], dp[pos]);
        return dp[pos];
    }

    int dpRight(int pos, int[]dp, int k, int[] nums) {
        if (pos==dp.length-1)
            return dp[dp.length-1];
        int maxRightDP = dpRight(pos+1, dp, k, nums);
        for (int i = pos+2; i < dp.length && i <= pos+k; i++) {
            maxRightDP = Math.max(maxRightDP, dpRight(i, dp, k, nums));
        }
        dp[pos] = nums[pos]+maxRightDP;
        return dp[pos];
    }

    @Test
    public void test() {
        assertEquals(11355, constrainedSubsetSum(new int[]{-5266,4019,7336,-3681,-5767}, 2));
        assertEquals(206, constrainedSubsetSum(new int[]{-7,-3,5,-6,48,-3,-10,5,20,31,100,-1}, 2));
        assertEquals(191, constrainedSubsetSum(new int[]{-7,48,-3,-10,5,20,31,100,-1}, 1));
        assertEquals(191, constrainedSubsetSum(new int[]{48,-3,-10,5,20,31,100}, 1));
        assertEquals(23, constrainedSubsetSum(new int[]{10,-2,-10,-5,20}, 2));
        assertEquals(-1, constrainedSubsetSum(new int[]{-1,-2,-3}, 1));
        assertEquals(37, constrainedSubsetSum(new int[]{10,2,-10,5,20}, 2));
        assertEquals(195, constrainedSubsetSum(new int[]{100,-4,-1,-2,-2,-3,-2,-1,100}, 2));
        assertEquals(185, constrainedSubsetSum(new int[]{100,-4,-1,-2,-2,-3,-2,-1,100}, 1));
    }
}
