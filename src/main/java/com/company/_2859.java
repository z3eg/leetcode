package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*2859. Sum of Values at Indices With K Set Bits
        https://leetcode.com/problems/sum-of-values-at-indices-with-k-set-bits/*/
public class _2859 {

    /*2ms
    Beats 43.10%of users with Java*/
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        if (k==0)
            return nums.get(0);
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (getSetBitsCount(i)==k)
                sum+=nums.get(i);
        }
        return sum;
    }

    int getSetBitsCount(int num) {
        int res = 0;
        while (num>=1) {
            res+=num%2;
            num/=2;
        }
        return res;
    }

    @Test
    public void testGBC() {
        assertEquals(0, getSetBitsCount(0));
        assertEquals(1, getSetBitsCount(1));
        assertEquals(1, getSetBitsCount(2));
        assertEquals(2, getSetBitsCount(3));
    }

    @Test
    public void test() {
        assertEquals(13, sumIndicesWithKSetBits(Arrays.asList(5,10,1,5,2), 1));
        assertEquals(1, sumIndicesWithKSetBits(Arrays.asList(4,3,2,1), 2));
    }
}
