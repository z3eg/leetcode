package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _2073 {

    /*2
    ms
    Beats
    69.86%
    of users with Java*/
    public int timeRequiredToBuy(int[] tickets, int k) {
        int pos = 0;
        int counter = 0;
        while (tickets[k]>0) {
            if (pos==tickets.length)
                pos = 0;
            if (tickets[pos] > 0) {
                tickets[pos]--;
                counter++;
            }
            pos++;
        }
        return counter;
    }

    @Test
    public void test() {
        assertEquals(6, timeRequiredToBuy(new int[]{2,3,2}, 2));
        assertEquals(8, timeRequiredToBuy(new int[]{5,1,1,1}, 0));
    }
}
