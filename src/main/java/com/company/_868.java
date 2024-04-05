package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _868 {

    /*0
    ms
    Beats
    100.00%
    of users with Java*/
    public int binaryGap(int n) {
        int prev = -1;
        int counter = 0;
        int max = 0;
        while (n>=1) {
            counter++;
            int mod = n % 2;
            if (mod == 1) {
                if (prev != -1)
                    max = Math.max(max, counter - prev);
                prev = counter;
            }
            n /= 2;
        }
        return max;
    }

    @Test
    public void test() {
        assertEquals(2, binaryGap(22));
        assertEquals(0, binaryGap(8));
        assertEquals(2, binaryGap(5));
    }
}
