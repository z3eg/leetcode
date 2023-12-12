package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _367 {

    /*0
    ms
            Beats
100.00%
    of users with Java*/
    /*public boolean isPerfectSquare(int num) {
        return bs(1,46340, num) != -1;
    }

    int bs(int l, int r, int num) {
        if (l*l == num)
            return l;
        if (r*r == num)
            return r;
        if (r-l < 2) {
            return -1;
        }
        int mid = (l+r)/2;
        int midSquare = mid * mid;
        if (midSquare == num)
            return mid;
        else if (midSquare > num) {
            return bs(l, mid, num);
        }
        else  {
            return bs(mid, r, num);
        }
    }*/


    /*0
    ms
            Beats
100.00%
    of users with Java*/
    public boolean isPerfectSquare(int num) {
        return Math.pow(num,0.5)%1==0;
    }

    @Test
    public void test() {
        assertTrue(isPerfectSquare(1));
        assertTrue(isPerfectSquare(4));
        assertTrue(isPerfectSquare(9));
        assertTrue(isPerfectSquare(16));
        assertTrue(isPerfectSquare(2147395600));
        assertFalse(isPerfectSquare(2147483647));
        assertFalse(isPerfectSquare(14));
    }
}
