package com.company;

//https://leetcode.com/contest/biweekly-contest-103/problems/maximum-sum-with-exactly-k-elements/
public class _6406_MaximumSumWithExactlyKElements {
    public int maximizeSum(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) 
                max = nums[i];
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum+=max;
            max++;
        }
        return sum;
    }
}
