package com.company;

//https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/
public class _2176_CountEqualAndDivisiblePairs {


    public int countPairs(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]==nums[j] && (i*j)%k==0)
                    res++;
            }
        }
        return res;
    }

}
