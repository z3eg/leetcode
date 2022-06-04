package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/divide-two-integers/
public class _29_DivideTwoIntegers {

    //TODO finish this one
    public int divide(int dividend, int divisor) {
        if (divisor==1) return dividend;
        if (divisor==0) return Integer.MAX_VALUE;
        if (dividend==-2147483648 && divisor==-1) return 2147483647;
        int absDivid = Math.abs(dividend);
        if (absDivid==-2147483648) absDivid = 2147483647;
        int absDivis = Math.abs(divisor);
        if (absDivid < absDivis) return 0;
        int res = 0;
        if (absDivid != absDivis) {
            while (absDivid >= absDivis) {
                absDivid -= absDivis;
                res++;
            }
            if (dividend == -2147483648 && ((absDivis&1)==1)) res++;
        }
        else {
            res=1;
        }
        if ((dividend<0 && divisor >0) || (dividend>0 && divisor<0)) {
            return Integer.parseInt("-"+res);
        }
        return res;
    }

    /*Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.*/

    @Test
    public void test() {
        assertEquals(1, divide(2,2));
        assertEquals(0, divide(1,2));
        assertEquals(715827883, divide(-2147483648,-3));
        assertEquals(-1073741824, divide(-2147483648,2));
        assertEquals(-2147483648, divide(-2147483648,1));
        assertEquals(2147483647, divide(2147483647, 1));
        assertEquals(2147483647, divide(-2147483648,-1));
        assertEquals(0, divide(0,1));
        assertEquals(3, divide(10,3));
        assertEquals(-2, divide(7,-3));
    }

}
