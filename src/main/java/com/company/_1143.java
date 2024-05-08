package com.company;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class _1143 {
    /*20
    ms
            Beats
82.44%
    of users with Java*/
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        assertEquals(3, longestCommonSubsequence("abcde","ace"));
        assertEquals(3, longestCommonSubsequence("abc","abc"));
        assertEquals(0, longestCommonSubsequence("abc","def"));
    }
}
