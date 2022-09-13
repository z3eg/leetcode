package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _326_PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n==1)
            return true;
        double d = (double) n;
        while (d>3)
            d/=3;
        return d==3;
    }

    @Test
    public void test() {
        assertFalse(isPowerOfThree(19684));
        assertFalse(isPowerOfThree(45));
        assertTrue(isPowerOfThree(1));
        assertTrue(isPowerOfThree(9));
        assertTrue(isPowerOfThree(27));
    }
}
