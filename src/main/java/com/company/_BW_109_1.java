package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

//6930. Check if Array is Good
public class _BW_109_1 {

    public boolean isGood(int[] nums) {
        int[] ints = new int[nums.length];
        for (int n : nums) {
            if (n >= ints.length)
                return false;
            ints[n]++;
        }
        for (int i = 1; i < ints.length - 1; i++) {
            if (ints[i]!=1)
                return false;
        }
        return ints[ints.length - 1] == 2;
    }

    @Test
    public void test() {
        assertTrue(isGood(new int[]{1, 3, 3, 2}));
        assertFalse(isGood(new int[]{2,1,3}));
        assertTrue(isGood(new int[]{1,1}));
        assertFalse(isGood(new int[]{3, 4, 4, 1, 2, 1}));
    }
}
