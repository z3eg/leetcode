package com.company;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class _1887 {

    /*35
    ms
            Beats
47.37%
    of users with Java*/
    public int reductionOperations(int[] nums) {
        int[] freqs = new int[50001];
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            freqs[n]++;
            min = Math.min(min, n);
            set.add(n);
        }
        int res = 0;
        int tiers = set.size();
        tiers--;
        for (int i = 50000; i > min; i--) {
            if (freqs[i]!=0) {
                res+=freqs[i]*tiers;
                tiers--;
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(10, reductionOperations(new int[]{1,2,3,4,5}));
        assertEquals(3, reductionOperations(new int[]{5,1,3}));
        assertEquals(0, reductionOperations(new int[]{1,1,1}));
        assertEquals(4, reductionOperations(new int[]{1,1,2,2,3}));
        assertEquals(0, reductionOperations(new int[]{1}));
        assertEquals(0, reductionOperations(new int[]{48324}));
    }
}
