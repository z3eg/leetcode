package com.company;

import java.util.Arrays;

//https://leetcode.com/problems/find-greatest-common-divisor-of-array/
public class _1979_FindGreatestCommonDivisorOfArray {

    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            if (max<i)
                max = i;
            if (min>i)
                min = i;
        }
        for (int i = min; i > 0; i--) {
            if (max%i==0 && min%i==0)
                return i;
        }
        return 1;
    }

}
