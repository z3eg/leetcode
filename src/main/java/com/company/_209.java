package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*209. Minimum Size Subarray Sum
        https://leetcode.com/problems/minimum-size-subarray-sum/*/
public class _209 {
    /*Runtime
    1 ms
    Beats
    100%*/
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int l = 0;
        int r = 0;
        int curLen = 0;
        int minLen = Integer.MAX_VALUE;
        while (r < nums.length) {
            while (sum < target && r < nums.length) {
                sum+=nums[r];
                r++;
                curLen++;
            }
            while (sum >= target && l < r) {
                minLen = Math.min(minLen, curLen);
                sum-=nums[l];
                l++;
                curLen--;
            }
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }

    @Test
    public void test() {
        assertEquals(1, minSubArrayLen(4, new int[]{4}));
        assertEquals(1, minSubArrayLen(4, new int[]{6}));
        assertEquals(0, minSubArrayLen(4, new int[]{2}));
        assertEquals(2, minSubArrayLen(6, new int[]{4,2}));
        assertEquals(1, minSubArrayLen(4, new int[]{4,9}));
        assertEquals(1, minSubArrayLen(4, new int[]{4,1}));
        assertEquals(1, minSubArrayLen(4, new int[]{1,4}));
        assertEquals(0, minSubArrayLen(4, new int[]{1,2}));
        assertEquals(0, minSubArrayLen(4, new int[]{2}));
        assertEquals(3, minSubArrayLen(22, new int[]{6,4,9,3,1,2,2,8,7,8,1,1,2,9,3,8}));
        assertEquals(3, minSubArrayLen(18, new int[]{7,2,3,2,9,1,9,2,3,5,7}));
        assertEquals(2, minSubArrayLen(7, new int[]{4,3,2,1,3,2}));
        assertEquals(2, minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        assertEquals(1, minSubArrayLen(4, new int[]{1,4,4}));
        assertEquals(0, minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }
}
