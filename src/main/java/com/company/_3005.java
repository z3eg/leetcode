package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _3005 {

    /*1
    ms
            Beats
99.64%
    of users with Java*/
    public int maxFrequencyElements(int[] nums) {
        int[] freqs = new int [101];
        int maxFreq = 0;
        for (int n : nums) {
            freqs[n]++;
            maxFreq = Math.max(maxFreq,freqs[n]);
        }
        int sum = 0;
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i] == maxFreq)
                sum+=maxFreq;
        }
        return sum;
    }

    @Test
    public void test() {
        assertEquals(4, maxFrequencyElements(new int[]{1,2,2,3,1,4}));
        assertEquals(5, maxFrequencyElements(new int[]{1,2,3,4,5}));
    }
}
