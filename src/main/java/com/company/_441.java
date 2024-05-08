package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _441 {

    /*8
ms
Beats
17.29%
of users with Java*/
    public int arrangeCoins(int n) {
        if (n==1)
            return 1;
        int limit = n;
        for (int i = 1; i <= limit; i++) {
            n-=i;
            if (n<0)
                return i-1;
        }
        return 0;
    }

    @Test
    public void test() {
//        assertEquals(1, arrangeCoins(1));
        assertEquals(2, arrangeCoins(5));
        assertEquals(3, arrangeCoins(8));
    }
}
