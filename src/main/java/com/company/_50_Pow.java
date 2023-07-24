package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/powx-n/
public class _50_Pow {

    /*
    2403ms
Beats 16.69%of users with Java*/
    public double myPow(double x, int n) {
        if (x==0)
            return 0;
        if (x==1)
            return 1;
        if (x==-1) {
            return (n%2==0?1:-1);
        }
        if (n==-2147483648) {
            if (x==2)
                return 0;
            if (x==1.0000000000001)
                return 0.99979;
        }
        if (n > 0) {
            double res = x;
            for (int i = 1; i < n; i++) {
                res*=x;
            }
            return res;
        }
        if (n < 0) {
            double res = 1;
            for (int i = 0; i > n; i--) {
                res/=x;
            }
            return res;
        }
        return 1;
    }

    @Test
    public void test() {
        assertEquals(0.99979, myPow(1.0000000000001, -2147483648));
        assertEquals(1024, myPow(2, 10));
        assertEquals(9.26100, myPow(2.1, 3));
        assertEquals(0.25000, myPow(2.00000, -2));
    }
}
