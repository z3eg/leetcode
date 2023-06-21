package com.company;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/*2442. Count Number of Distinct Integers After Reverse Operations
        https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/*/
public class _2442 {

    /*Runtime
    75 ms
    Beats
    60.75%*/
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
            set.add(reverseDigits(n));
        }
        return set.size();
    }

    private int reverseDigits(int n) {
        if (n<10)
            return n;
        int newNum = 0;
        while (n>=1) {
            newNum*=10;
            newNum+=n%10;
            n/=10;
        }
        return newNum;
    }

    @Test
    public void testReverseDigits() {
        assertEquals(31, reverseDigits(13));
        assertEquals(3, reverseDigits(3));
        assertEquals(32451, reverseDigits(15423));
    }

    @Test
    public void test() {
        assertEquals(6, countDistinctIntegers(new int[]{1,13,10,12,31}));
        assertEquals(1, countDistinctIntegers(new int[]{2,2,2}));
    }
}
