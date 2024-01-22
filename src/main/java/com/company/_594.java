package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _594 {
    public int findLHS(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i];

        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(5, findLHS(new int[]{1,3,2,2,5,2,3,7}));
        assertEquals(2, findLHS(new int[]{1,2,3,4}));
        assertEquals(0, findLHS(new int[]{1,1,1,1}));
    }
}
