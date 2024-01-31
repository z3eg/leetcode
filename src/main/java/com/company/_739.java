package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class _739 {
    //naive n^2
    /*Time Limit Exceeded
47 / 48 testcases passed*/
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{1,1,4,2,1,1,0,0}, dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
        assertArrayEquals(new int[]{1,1,1,0}, dailyTemperatures(new int[]{30,40,50,60}));
        assertArrayEquals(new int[]{1,1,0}, dailyTemperatures(new int[]{30,60,90}));
    }
}
