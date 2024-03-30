package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _860 {

    /*2
    ms
    Beats
    96.80%
    of users with Java*/
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for (int b : bills) {
            if (b==5)
                fives++;
            if (b==10) {
                if (fives<1)
                    return false;
                else {
                    fives--;
                    tens++;
                }
            }
            if (b==20) {
                if (fives<1)
                    return false;
                if (tens<1 && fives<3)
                    return false;
                else {
                    if (tens > 0) {
                        tens--;
                        fives--;
                    }
                    else {
                        fives-=3;
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(lemonadeChange(new int[]{5,5,5,10,20}));
        assertTrue(lemonadeChange(new int[]{5,10,5,20}));
        assertFalse(lemonadeChange(new int[]{5,5,10,10,20}));
        assertFalse(lemonadeChange(new int[]{10}));
        assertFalse(lemonadeChange(new int[]{20}));
    }
}
