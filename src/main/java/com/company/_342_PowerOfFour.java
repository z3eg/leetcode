package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//https://leetcode.com/problems/power-of-four/
public class _342_PowerOfFour {
    public boolean isPowerOfFour(int n) {
        double d = n;
        while (d>1) {
            d/=4;
        }
        return d==1;
    }

    @Test
    public void test() {
        assertTrue(isPowerOfFour(64));
        assertTrue(isPowerOfFour(4));
        assertFalse(isPowerOfFour(1_162_261_466));
        assertTrue(isPowerOfFour(16));
        assertFalse(isPowerOfFour(0));
    }
}
