package com.company;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/*961. N-Repeated Element in Size 2N Array
        https://leetcode.com/problems/n-repeated-element-in-size-2n-array/*/
public class _961 {

    /*Beats 100.00%of users with Java*/
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n))
                return n;
            set.add(n);
        }
        return 0;
    }

    @Test
    public void test() {
        assertEquals(3, repeatedNTimes(new int[]{1,2,3,3}));
        assertEquals(2, repeatedNTimes(new int[]{2,1,2,5,3,2}));
        assertEquals(5, repeatedNTimes(new int[]{5,1,5,2,5,3,5,4}));
    }
}
