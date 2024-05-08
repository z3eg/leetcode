package com.company;

import java.util.Arrays;

public class _2441 {
    /*4
    ms
    Beats
    91.11%
    of users with Java*/
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        while (l<r && nums[l]<1 && nums[r] >=1) {
            if (Math.abs(nums[l]) == nums[r])
                return nums[r];
            if (Math.abs(nums[l]) < nums[r])
                r--;
            else
                l++;
        }
        return -1;
    }
}
