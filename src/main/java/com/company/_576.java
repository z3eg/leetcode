package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _576 {

    /*Wrong Answer
30 / 94 testcases passed*/
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i]++;
            dp[dp.length-1][i]++;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0]++;
            dp[i][dp[0].length-1]++;
        }
        return dp(startRow, startColumn, maxMove, dp);
    }

    private int dp(int r, int c, int movesLeft, int[][] dp) {
        if (r<0 || r>=dp.length || c < 0 || c >= dp[0].length)
            return 0;
        if (movesLeft<=0)
            return 0;
        dp[r][c] += dp(r-1,c,movesLeft-1, dp) + dp(r+1,c,movesLeft-1, dp) +
                dp(r, c-1, movesLeft-1, dp) + dp(r, c+1, movesLeft-1, dp);
        return dp[r][c];
    }

    @Test
    public void test() {
        assertEquals(6, findPaths(2,2,2,0,0));
        assertEquals(12, findPaths(1,3,3,0,1));
    }
}
