package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*1027. Longest Arithmetic Subsequence
        https://leetcode.com/problems/longest-arithmetic-subsequence/*/
public class _1027 {

    //TLE
    public int longestArithSeqLength(int[] nums) {
        int numLen = nums.length;
        if (numLen==2)
            return 2;
        int maxStreak = 0;
        return buildATree(nums[0], nums, 1, Integer.MAX_VALUE, maxStreak, 1, numLen)+1;
    }

    int buildATree(int root, int[] nums, int curPos, int lastDiff, int maxStreak, int curStreak, int len) {
        if (curStreak+(len-curPos) < maxStreak)
            return curStreak;
        for (int i = curPos; i < len; i++) {
            int curDiff = root - nums[i];
            if (lastDiff == curDiff)
                curStreak++;
            else
                curStreak = 1;
            maxStreak = Math.max(maxStreak, curStreak);
            maxStreak = Math.max(maxStreak, buildATree(nums[i], nums, i+1, curDiff, maxStreak, curStreak, len));
        }
        return maxStreak;
    }

    @Test
    public void test() {
        assertEquals(4, longestArithSeqLength(new int[]{3,6,9,12}));
        assertEquals(2, longestArithSeqLength(new int[]{83,20,17,43,52,78,68,45}));
        assertEquals(3, longestArithSeqLength(new int[]{9,4,7,2,10}));
        assertEquals(4, longestArithSeqLength(new int[]{20,1,15,3,10,5,8}));
    }
}
