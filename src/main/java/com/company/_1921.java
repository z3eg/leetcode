package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _1921 {

    /*22ms
    Beats 41.15%of users with Java*/
    /*public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] times = new double[n];
        for (int i = 0; i < n; i++) {
            times[i] = (double) dist[i] /speed[i];
        }
        int timePassed = 0;
        Arrays.sort(times);
        for (int i = 0; i < times.length; i++) {
            if (times[i] - timePassed <= 0)
                return i;
            timePassed++;
        }
        return n;
    }*/

    /*21ms
    Beats 57.81%of users with Java*/
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] times = new double[n];
        for (int i = 0; i < n; i++) {
            times[i] = (double) dist[i] /speed[i];
        }
        Arrays.sort(times);
        for (int i = 0; i < times.length; i++) {
            if (times[i] - i <= 0)
                return i;
        }
        return n;
    }

    @Test
    public void test() {
        assertEquals(1, eliminateMaximum(new int[]{1,3,4}, new int[]{2,1,9}));
        assertEquals(3, eliminateMaximum(new int[]{1,3,4}, new int[]{1,1,1}));
        assertEquals(1, eliminateMaximum(new int[]{1,1,2,3}, new int[]{1,1,1,1}));
        assertEquals(1, eliminateMaximum(new int[]{3,2,4}, new int[]{5,3,2}));
    }
}
