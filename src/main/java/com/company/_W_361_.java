package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _W_361_ {

    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++) {
            if (isSymmetric(i))
                res++;
        }
        return res;
    }

    private boolean isSymmetric(int i) {
        if (i<10)
            return false;
        if (i > 99 && i < 1000)
            return false;
        if (i==10000)
            return false;
        if (i < 100) {
            return (i==(i%10) + (i%10)*10);
        }
        else {
            int[] digs = new int[4];
            int counter = 0;
            while (counter<4) {
                digs[3-counter] = i%10;
                i/=10;
                counter++;
            }
            return (digs[0]+digs[1]==digs[2]+digs[3]);
        }
    }

    @Test
    public void test() {
        assertEquals(9, countSymmetricIntegers(1, 100));
        assertEquals(4, countSymmetricIntegers(1200, 1230));
    }
}
