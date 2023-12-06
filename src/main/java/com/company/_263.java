package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _263 {

    /*Wrong Answer
428 / 1013 testcases passed*/
    public boolean isUgly(int n) {
        for (int i = 2; i < n; i++) {
            if (n%i==0 && (n/i!=3 && n/i!=2 && n/i!=5))
                    return false;
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(isUgly(6));
        assertTrue(isUgly(1));
        assertFalse(isUgly(14));
    }
}
