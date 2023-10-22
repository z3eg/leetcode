package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _70 {
    /*Time Limit Exceeded
    21 / 45 testcases passed*/
    /*public int climbStairs(int n) {
        return climb(n, 0, 0);
    }

    int climb(int n, int cur, int res) {
        if (cur==n) {
            return res+1;
        }
        if (cur>n)
            return res;
        res = climb(n, cur+1, res);
        res = climb(n, cur+2, res);
        return res;
    }*/
/*
    public int climbStairs(int n) {
        int dp[] = new int[45];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        return dp(n, 0, 0, dp);
    }

    int dp(int n, int[] dp) {
        if (dp[n] != 0)
            return dp[n];

        return res;
    }*/

    /*0ms
    Beats 100.00%of users with Java*/
    public int climbStairs(int n) {
        int[] dp = new int[46];
        dp[1] = 1;
        dp[2] = 2;
        return climb(n, dp);
    }

    int climb(int n, int[] dp) {
        if (dp[n]!=0)
            return dp[n];
        dp[n] = climb(n-1, dp) + climb(n-2, dp);
        return dp[n];
    }

    @Test
    public void test() {
        climbStairs(45);
        assertEquals(1, climbStairs(1));
        assertEquals(2, climbStairs(2));
        assertEquals(3, climbStairs(3));
    }
}
