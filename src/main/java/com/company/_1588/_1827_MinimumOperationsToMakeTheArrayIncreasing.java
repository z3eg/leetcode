package com.company._1588;

//https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
public class _1827_MinimumOperationsToMakeTheArrayIncreasing {

    public int minOperations(int[] nums) {
        int res = 0;
        int length = nums.length;
        for (int i = 0; i < length-1; i++) {
            if (nums[i]>=nums[i+1]) {
                int diff = nums[i] - nums[i + 1] + 1;
                nums[i+1]+=diff;
                res+=diff;
            }
        }
        return res;
    }
}
