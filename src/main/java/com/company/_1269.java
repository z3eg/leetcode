package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/description/?envType=daily-question&envId=2023-10-15
public class _1269 {
    //TODO obviously a dp problem, gonna implement naive recursion first tho to understand the logic
    /*public int numWays(int steps, int arrLen) {
        int[][] dp = new int[steps+1][arrLen+1];
        return dp[steps][arrLen];
    }

    int count(int steps, int arrLen, int[][]dp) {
        if (dp[steps][arrLen] != 0)
            return dp[steps][arrLen];
        dp[steps][arrLen] = dp[steps-1][arrLen]
    }*/

    //seemingly working naive recursion solution
    /*public int numWays(int steps, int arrLen) {
        return count(steps, 0, arrLen, 0);
    }

    int count(int steps, int idx, int arrLen, int curWays) {
        if (steps == 0 && idx == 0)
            return ++curWays;
        if (steps < 0)
            return curWays;
        if (idx > 0) {
            curWays = count(steps-1, idx-1, arrLen, curWays);
        }
        if (idx < arrLen-1) {
            curWays = count(steps-1, idx+1, arrLen, curWays);
        }
        curWays = count(steps-1, idx, arrLen, curWays);
        return curWays;
    }*/


    /*Time Limit Exceeded
14 / 33 testcases passed*/
    /*public int numWays(int steps, int arrLen) {
        if (arrLen==1)
            return steps;
        long[][] dp = new long[steps+1][arrLen+1];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[2][0] = 2;
        dp[2][1] = 2;
        dp[2][2] = 1;
        return (int) (count(steps, 0, arrLen, 0, dp) % (Math.pow(10,9) + 7));
    }

    long count(int steps, int idx, int arrLen, long curWays, long[][] dp) {
        if (steps < 0 || idx < 0 || idx >= arrLen)
            return 0;
        if (dp[steps][idx]!=0) {
            return dp[steps][idx];
        }
        if (steps == 0 && idx == 0) {
            dp[steps][idx] = curWays+1;
            return curWays+1;
        }
        curWays = count(steps - 1, idx - 1, arrLen, curWays, dp);
        curWays += count(steps - 1, idx + 1, arrLen, curWays, dp);
        curWays += count(steps - 1, idx, arrLen, curWays, dp);
        dp[steps][idx] = curWays;
        return curWays;
    }*/

    //still TLE
    /*public int numWays(int steps, int arrLen) {
        if (arrLen==1)
            return steps;
        int[][] dp = new int[steps+1][arrLen+1];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[2][0] = 2;
        dp[2][1] = 2;
        dp[2][2] = 1;
        int res = count(steps, 0, arrLen, dp);
        return res;
    }

    int count(int steps, int idx, int arrLen, int[][] dp) {
        if (steps < 0)
            return 0;
        int curWays = dp[steps][idx]!=0?dp[steps-1][idx]:count(steps - 1, idx, arrLen, dp);
        if (idx > 0)
            curWays += dp[steps][idx-1]!=0?dp[steps-1][idx-1]:count(steps - 1, idx - 1, arrLen, dp);
        if (idx < arrLen-1)
            curWays += dp[steps][idx+1]!=0?dp[steps-1][idx+1]:count(steps - 1, idx + 1, arrLen, dp);
        dp[steps][idx] = curWays % 1000000007;
        return curWays;
    }*/

    /*Runtime
    10 ms
    Beats
    63.41%*/
    public int numWays(int steps, int arrLen) {
        int n = Math.min(steps / 2 + 1, arrLen);
        int[][] dp = new int[steps+1][n];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i-1][j];
                if (j>0) {
                    dp[i][j] += dp[i-1][j-1];
                    dp[i][j]%=1000000007;
                }
                if (j<n-1) {
                    dp[i][j] += dp[i-1][j+1]%1000000007;
                    dp[i][j]%=1000000007;
                }
            }
        }
        return dp[steps][0];
    }

    @Test
    public void test() {
        assertEquals(50852019, numWays(20,20));
        assertEquals(4, numWays(3,2));
        assertEquals(2, numWays(2,4));
        assertEquals(8, numWays(4,2));
    }
}
