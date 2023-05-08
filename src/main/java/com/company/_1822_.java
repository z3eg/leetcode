package com.company;

//https://leetcode.com/problems/sign-of-the-product-of-an-array/
//1822. Sign of the Product of an Array

public class _1822_ {
    public int arraySign(int[] nums) {
        boolean isPositive = true;
        for (int num : nums) {
            if (num == 0)
                return 0;
            else if (num < 0)
                isPositive = !isPositive;
        }
        return isPositive?1:-1;
    }
}
