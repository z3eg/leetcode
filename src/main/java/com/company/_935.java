package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _935 {
    public static int MOD = 1_000_000_007;
    public int knightDialer(int n) {
        int res = 0;
        int[][] dp = new int[n+1][10];
        Arrays.fill(dp[1],1);
        for (int i = 0; i < 10; i++) {
            res = (res + numbersFromThisDigit(i,n,dp)) % MOD;
        }
        return res;
    }

    private int numbersFromThisDigit(int lastDigit, int n, int[][]dp) {
        if (dp[n][lastDigit] != 0)
            return dp[n][lastDigit];
        int[] nextDigits = nextDigits(lastDigit);
        for (int nd : nextDigits) {
            dp[n][lastDigit] = (dp[n][lastDigit] + numbersFromThisDigit(nd, n-1, dp)) % MOD;
        }
        return dp[n][lastDigit];
    }

    int[] nextDigits(int dig) {
        return switch (dig) {
            case 0 -> new int[]{6,4};
            case 1 -> new int[]{6,8};
            case 2 -> new int[]{7,9};
            case 3 -> new int[]{4,8};
            case 4 -> new int[]{3,9,0};
            case 5 -> new int[]{};
            case 6 -> new int[]{1,7,0};
            case 7 -> new int[]{6,2};
            case 8 -> new int[]{1,3};
            case 9 -> new int[]{4,2};
            default -> null;
        };
    }

    @Test
    public void test() {
        assertEquals(136006598, knightDialer(3131));
        assertEquals(10, knightDialer(1));
        assertEquals(20, knightDialer(2));
    }
}
