package com.company;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/
public class _1464_MaximumProductofTwoElementsanArray {

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int numLen = nums.length;
        return (nums[numLen-1]-1)*(nums[numLen-2]-1);
    }

}
