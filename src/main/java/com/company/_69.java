package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*69. Sqrt(x)
        https://leetcode.com/problems/sqrtx/description/*/
public class _69 {

    /*1ms
    Beats 97.21%of users with Java*/
    public int mySqrt(int x) {
        if (x==1)
            return 1;
        return bs(0, x, x);
    }


    int bs(int l, int r, int x) {
        if ((r-l)<=1)
            return l;
        int mid = (l+r)/2;
        long square = mid;
        square*=mid;
        if (square == x)
            return mid;
        if (square > x) {
            return bs(l, mid, x);
        }
        if (square < x) {
            return bs(mid, r, x);
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(2, mySqrt(4));
        assertEquals(2, mySqrt(8));
        assertEquals(0, mySqrt(0));
    }
}
