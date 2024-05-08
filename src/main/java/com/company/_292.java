package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _292 {

    /*0
    ms
            Beats
100.00%
    of users with Java*/
    public boolean canWinNim(int n) {
        return n%4!=0;
    }

    @Test
    public void test() {
        assertFalse(canWinNim(4));
        assertTrue(canWinNim(1));
        assertTrue(canWinNim(2));
    }
}
