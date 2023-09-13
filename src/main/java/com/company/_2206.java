package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*https://leetcode.com/problems/divide-array-into-equal-pairs/description/
        2206. Divide Array Into Equal Pairs*/
public class _2206 {
    /*1ms
    Beats 99.81%of users with Java*/
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501];
        for (int n : nums) {
            freq[n]++;
        }
        for (int f : freq) {
            if (f%2!=0)
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(divideArray(new int[]{3,2,3,2,2,2}));
        assertFalse(divideArray(new int[]{1,2,3,4}));
    }
}
