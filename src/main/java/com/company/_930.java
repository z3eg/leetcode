package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int l = 0;
        int r = 0;
        int curSum = 0;
        int res = 0;
        while (r < nums.length) {
            while (curSum < goal) {
                r++;
                curSum+=nums[r];
            }
            while (curSum > goal && l<r) {
                l++;
                curSum-=nums[l];
            }
            while (curSum == goal && l<r) {
                res++;
                l++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(4, numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
        assertEquals(1, numSubarraysWithSum(new int[]{1}, 1));
        assertEquals(0, numSubarraysWithSum(new int[]{0}, 1));
        assertEquals(0, numSubarraysWithSum(new int[]{1}, 2));
        assertEquals(0, numSubarraysWithSum(new int[]{1,1}, 0));
        assertEquals(15, numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
    }
}
