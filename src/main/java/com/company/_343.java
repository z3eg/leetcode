package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class _343 {
    /*1ms
    Beats 61.46%of users with Java*/
    public int integerBreak(int n) {
        if (n==2)
            return 1;
        if (n==3)
            return 2;
        int max = 0;
        int[] dp = new int[59];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        return maxM(n, max, dp);
    }

    int maxM(int n, int max, int[] dp) {
        if (dp[n]!=0)
            return dp[n];
        for (int i = 1; i < n; i++) {
            if (dp[i]==0)
                dp[i] = maxM(i, 0, dp);
            if (dp[n-i]==0)
                dp[n-i] = maxM(n-i, 0, dp);
            int cur = dp[i] * dp[n-i];
            max = Math.max(cur,max);
        }
        return max;
    }


    @Test
    public void test() {
        assertEquals(36, integerBreak(10));
        assertEquals(1, integerBreak(2));
    }
}
