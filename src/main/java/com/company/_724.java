package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _724 {

    /*Wrong Answer
315 / 746 testcases passed*/
    /*public int pivotIndex(int[] nums) {
        int lSum = 0;
        int rSum = 0;
        int l = 0;
        int r = nums.length-1;
        while (l<r) {
            if (lSum >= rSum) {
                rSum+=nums[r];
                r--;
            }
            else {
                lSum+=nums[l];
                l++;
            }
        }
        if (lSum==rSum)
            return r;
        else
            return -1;
    }*/

    public int pivotIndex(int[] nums) {
        int lSum = 0;
        int rSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rSum+=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            lSum+=nums[i];
            rSum-=nums[i];
            if (lSum==rSum)
                return i;
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(2, pivotIndex(new int[]{-1,-1,-1,-1,-1,0}));
        assertEquals(0, pivotIndex(new int[]{2,1,-1}));
        assertEquals(3, pivotIndex(new int[]{1,7,3,6,5,6}));
        assertEquals(-1, pivotIndex(new int[]{1,2,3}));
    }
}
