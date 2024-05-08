package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _414 {

    /*4
    ms
            Beats
54.70%
    of users with Java*/
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i]!=nums[i+1]) {
                count++;
            }
            if (count==3)
                return nums[i];
        }
        return nums[nums.length-1];
    }

    @Test
    public void test() {
        assertEquals(3, thirdMax(new int[]{3}));
        assertEquals(2, thirdMax(new int[]{1,2}));
        assertEquals(2, thirdMax(new int[]{1,2}));
        assertEquals(1, thirdMax(new int[]{2,2,3,1}));
    }
}
