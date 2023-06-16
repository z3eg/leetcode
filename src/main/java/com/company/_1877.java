package com.company;

import java.util.Arrays;

public class _1877 {
    /*beats 12.3%-42.39%*/
    //test comment
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            max = Math.max(max, nums[i] + nums[nums.length-1-i]);
        }
        return max;
    }
}
