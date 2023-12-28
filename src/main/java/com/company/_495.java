package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _495 {

    /*3
    ms
            Beats
49.82%
    of users with Java*/
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            res += Math.min(duration, timeSeries[i+1]-timeSeries[i]);
        }
        return res+duration;
    }

    @Test
    public void test() {
        assertEquals(4, findPoisonedDuration(new int[]{1,4}, 2));
        assertEquals(3, findPoisonedDuration(new int[]{1,2}, 2));
    }
}
