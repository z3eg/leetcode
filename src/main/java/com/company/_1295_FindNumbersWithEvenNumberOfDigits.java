package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class _1295_FindNumbersWithEvenNumberOfDigits {

    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums)
            if (digNum(num)%2==0)
                res++;
        return res;
    }

    private int digNum(int n) {
        int res = 0;
        while (n>=1) {
            res++;
            n/=10;
        }
        return res;
    }

    @Test
    public void testDigNum() {
        assertEquals(2, digNum(12));
    }

}
