package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*2057. Smallest Index With Equal Value
        https://leetcode.com/problems/smallest-index-with-equal-value/description/*/
public class _2057 {

    /*1ms
    Beats 28.92%of users with Java*/
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i%10==nums[i])
                return i;
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(0, smallestEqual(new int[]{0,1,2}));
        assertEquals(2, smallestEqual(new int[]{4,3,2,1}));
        assertEquals(-1, smallestEqual(new int[]{1,2,3,4,5,6,7,8,9,0}));
    }
}
