package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _231 {

    /*1
    ms
            Beats
86.05%
    of users with Java*/
    public boolean isPowerOfTwo(int n) {
        while (n>1) {
            if (n % 2 != 0)
                return false;
            n/=2;
        }
        return n==1;
    }

    @Test
    public void test() {
        assertTrue(isPowerOfTwo(1));
        assertTrue(isPowerOfTwo(16));
        assertFalse(isPowerOfTwo(3));
    }
}
