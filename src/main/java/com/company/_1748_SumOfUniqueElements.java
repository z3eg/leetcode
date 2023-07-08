package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/sum-of-unique-elements/
public class _1748_SumOfUniqueElements {
    /*Runtime
    0 ms
    Beats
    100%*/
    public int sumOfUnique(int[] nums) {
        int[] freqs = new int[101];
        for (int n : nums) {
            freqs[n]++;
        }
        int sum = 0;
        for (int i = 0; i < freqs.length; i++) {
            sum+=freqs[i]==1?i:0;
        }
        return sum;
    }

    @Test
    public void test() {
        assertEquals(4, sumOfUnique(new int[]{1,2,3,2}));
        assertEquals(0, sumOfUnique(new int[]{1,1,1,1,1}));
        assertEquals(15, sumOfUnique(new int[]{1,2,3,4,5}));
    }
}
