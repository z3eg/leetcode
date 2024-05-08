package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _485 {
    /*2
    ms
            Beats
83.48%
    of users with Java*/
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int n : nums) {
            if (n==1) {
                cur++;
            }
            if (n==0) {
                max = Math.max(max, cur);
                cur = 0;
            }
        }
        max = Math.max(max, cur);
        return max;
    }

    @Test
    public void test() {
        assertEquals(0, findMaxConsecutiveOnes(new int[]{0,0}));
        assertEquals(0, findMaxConsecutiveOnes(new int[]{0}));
        assertEquals(1, findMaxConsecutiveOnes(new int[]{1}));
        assertEquals(1, findMaxConsecutiveOnes(new int[]{1,0,1}));
        assertEquals(1, findMaxConsecutiveOnes(new int[]{0,1}));
        assertEquals(1, findMaxConsecutiveOnes(new int[]{0,1,0}));
        assertEquals(1, findMaxConsecutiveOnes(new int[]{1,0}));
        assertEquals(2, findMaxConsecutiveOnes(new int[]{1,1}));
        assertEquals(3, findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        assertEquals(4, findMaxConsecutiveOnes(new int[]{1,1,1,1,0,1,1,1}));
        assertEquals(2, findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
}
