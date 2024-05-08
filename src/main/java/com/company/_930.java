package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _930 {

    /*1842
    ms
    Beats
    5.25%
    of users with Java*/
    public int numSubarraysWithSum(int[] nums, int goal) {
        int k = goal;
        int numOfSubArrays = 0;
        for (int i = 0; i < nums.length; i++) {
            int localSum = 0;
            int curRightPos = i;
            do {
                localSum+=nums[curRightPos];
                curRightPos++;
                if (localSum==k) {
                    numOfSubArrays++;
                }
            } while (curRightPos<nums.length);
        }
        return numOfSubArrays;
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
