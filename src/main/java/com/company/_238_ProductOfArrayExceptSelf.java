package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

//https://leetcode.com/problems/product-of-array-except-self/
public class _238_ProductOfArrayExceptSelf {

    /*1ms
    Beats 100.00%of users with Java*/
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] pref = new int[nums.length];
        int[] post = new int[nums.length];
        int curProd = 1;
        for (int i = 0; i < nums.length; i++) {
            curProd*=nums[i];
            pref[i] = curProd;
        }
        curProd = 1;
        for (int i = nums.length-1; i >=0; i--) {
            curProd*=nums[i];
            post[i] = curProd;
        }
        res[0] = post[1];
        res[nums.length-1] = pref[nums.length-2];
        for (int i = 1; i < nums.length-1; i++) {
            res[i] = pref[i-1]*post[i+1];
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{24,12,8,6}, productExceptSelf(new int[]{1,2,3,4}));
        assertArrayEquals(new int[]{0,0,9,0,0}, productExceptSelf(new int[]{-1,1,0,-3,3}));
        assertArrayEquals(new int[]{17,8}, productExceptSelf(new int[]{8,17}));
        assertArrayEquals(new int[]{40,10,16}, productExceptSelf(new int[]{2,8,5}));
    }
}
