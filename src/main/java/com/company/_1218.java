package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*1218. Longest Arithmetic Subsequence of Given Difference
        https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/*/
public class _1218 {

    /*Time Limit Exceeded
    35 / 39 testcases passed*/
    /*public int longestSubsequence(int[] arr, int difference) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int curStreak = 1;
            int curArrI = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (curArrI+difference==arr[j]) {
                    curStreak++;
                    curArrI+=difference;
                }
            }
            res = Math.max(res, curStreak);
        }
        return res;
    }*/

    public int longestSubsequence(int[] arr, int difference) {
        return 0;
    }

    @Test
    public void test() {
        assertEquals(5, longestSubsequence(new int[]{2,3,4,3,5,7,9,11}, 2));
        assertEquals(4, longestSubsequence(new int[]{1,2,3,4}, 1));
        assertEquals(1, longestSubsequence(new int[]{1,3,5,7}, 1));
        assertEquals(4, longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, -2));
    }

}
