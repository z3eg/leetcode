package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
public class _1913_MaximumProductDifferenceBetweenTwoPairs {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length-1]*nums[nums.length-2]-nums[0]*nums[1];
    }

    @Test
    public void test() {
        System.out.println("HW");
    }
}
