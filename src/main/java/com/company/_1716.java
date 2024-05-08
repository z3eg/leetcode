package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _1716 {

    /*0
    ms
            Beats
100.00%
    of users with Java*/
    public int totalMoney(int n) {
        int weeks = n/7;
        n%=7;
        n+=weeks;
        return weeks*28+(((weeks*(weeks-1))/2)*7)+((n*(n+1))/2)-((weeks*(weeks+1))/2);
    }

    @Test
    public void test() {
        assertEquals(96,totalMoney(20));
        assertEquals(10,totalMoney(4));
        assertEquals(37,totalMoney(10));
    }
}
