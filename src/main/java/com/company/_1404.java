package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1404 {

    /*
31 / 73 testcases passed*/
    public int numSteps(String s) {
        long i = Long.parseLong(s, 2);
        int counter = 0;
        while (i != 1) {
            counter++;
            if (i%2==0)
                i/=2;
            else
                i+=1;
        }
        return counter;
    }

    @Test
    public void test() {
        assertEquals(6, numSteps("1101"));
        assertEquals(1, numSteps("10"));
        assertEquals(0, numSteps("1"));
    }
}
