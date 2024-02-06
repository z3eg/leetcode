package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _693 {

    /*0
    ms
            Beats
100.00%
    of users with Java*/
    public boolean hasAlternatingBits(int n) {
        boolean isEven = n%2==0;
        n/=2;
        while (n>=1) {
            if (isEven && n%2==0)
                return false;
            if (!isEven && n%2==1)
                return false;
            isEven = n%2==0;
            n/=2;
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(hasAlternatingBits(2));
        assertTrue(hasAlternatingBits(1));
        assertTrue(hasAlternatingBits(5));
        assertTrue(hasAlternatingBits(2));
        assertFalse(hasAlternatingBits(3));
        assertFalse(hasAlternatingBits(4));
        assertFalse(hasAlternatingBits(7));
        assertFalse(hasAlternatingBits(11));
    }
}
