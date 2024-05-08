package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _747 {

    /*1
    ms
            Beats
26.56%
    of users with Java*/
    public int dominantIndex(int[] nums) {
        int[] ints = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ints);
        if (ints[ints.length-1]==0)
            return -1;
        if (ints[ints.length-2]==0 || ints[ints.length-1]/ints[ints.length-2]>=2) {
            int lf = ints[ints.length-1];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == lf)
                    return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(1, dominantIndex(new int[]{0,1}));
        assertEquals(0, dominantIndex(new int[]{1,0}));
        assertEquals(0, dominantIndex(new int[]{1,0,0,0,0,0}));
        assertEquals(3, dominantIndex(new int[]{0,0,0,1}));
        assertEquals(1, dominantIndex(new int[]{3,6,1,0}));
        assertEquals(-1, dominantIndex(new int[]{1,2,3,4}));
    }
}
