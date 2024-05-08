package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _476 {

    /*0
    ms
            Beats
100.00%
    of users with Java*/
    public int findComplement(int num) {
        int res = 0;
        int pow = 0;
        while (num>=1) {
            int i = num % 2;
            if (i==0) res+=Math.pow(2,pow);
            pow++;
            num/=2;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(2, findComplement(5));
        assertEquals(0, findComplement(1));
    }
}
