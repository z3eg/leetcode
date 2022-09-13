package com.company;

//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
public class _1365_HowManyNumbersAreSmallerThantheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i]>nums[j])
                    res[i]++;
            }
        }
        return res;
    }
}
