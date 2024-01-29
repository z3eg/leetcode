package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1492 {

    /*Wrong Answer
177 / 208 testcases passed*/
    public int kthFactor(int n, int k) {
        int counter = 1;
        for (int i = 2; i <= n; i++) {
            if (n%i==0)
                counter++;
            if (counter==k)
                return i;
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(3, kthFactor(12, 3));
        assertEquals(7, kthFactor(7, 2));
        assertEquals(-1, kthFactor(4, 4));
    }
}
