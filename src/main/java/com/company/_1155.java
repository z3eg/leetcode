package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1155 {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[target][n];
        return 0;
    }

    int dp(int[][] dp, int n, int target) {
        if (dp[target][n]!=0)
            return dp[target][n];
        for (int i = 1; i < n; i++) {
            dp[target][n]+=dp(dp, i, target-i);
        }
        return dp[target][n];
    }
    @Test
    public void test() {
        assertEquals(1, numRollsToTarget(1,6,3));
        assertEquals(6, numRollsToTarget(2,6,7));
        assertEquals(15, numRollsToTarget(3,6,7));
        assertEquals(222616187, numRollsToTarget(30,30,500));
    }
}
