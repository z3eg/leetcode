package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/single-number/
public class _136_SingleNumber {

    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
        int sum = 0;
        int multiplier = 1;
        for (int n: nums) {
            sum+=n*multiplier;
            multiplier*=-1;
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(singleNumber(new int[]{2,2,1}));
//        assertEquals(1, singleNumber(new int[]{2,2,1}));
       /* assertEquals(4, singleNumber(new int[]{4,1,2,1,2}));
        assertEquals(1, singleNumber(new int[]{1}));*/
    }

    /*Example 1:

    Input: nums = [2,2,1]
    Output: 1
    Example 2:

    Input: nums = [4,1,2,1,2]
    Output: 4
    Example 3:

    Input: nums = [1]
    Output: 1*/

}
