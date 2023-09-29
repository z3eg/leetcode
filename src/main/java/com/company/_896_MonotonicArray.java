package com.company;

public class _896_MonotonicArray {

    /*2ms
    Beats 62.86%of users with Java*/
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2)
            return true;
        boolean descending = false;
        int i = 1;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                descending = true;
                break;
            }
            if (nums[i] > nums[i-1]) {
                break;
            }
        }
        for (int j = i; j < nums.length-1; j++) {
            if (nums[j] < nums[j+1] && descending)
                return false;
            if (nums[j] > nums[j+1] && !descending)
                return false;
        }
        return true;
    }
}
