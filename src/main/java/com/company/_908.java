package com.company;

public class _908 {

    /*3
ms
Beats
75.82%
of users with Java*/
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0];
        int min = nums[0];
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        int diff = max-min;
        return (diff > 2*k)?diff-2*k:0;
    }
}
