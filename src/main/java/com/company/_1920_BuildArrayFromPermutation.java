package com.company;

//https://leetcode.com/problems/build-array-from-permutation/
public class _1920_BuildArrayFromPermutation {

    public int[] buildArray(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
