package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//https://leetcode.com/problems/shuffle-the-array
public class _1470_ShuffleTheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        for (int i = 0; i < n; i++) {
            res[i*2] = nums[i];
            res[i*2+1] = nums[i+n];
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{2,3,5,4,1,7}, shuffle(new int[]{2,5,1,3,4,7}, 3));
        assertArrayEquals(new int[]{1,4,2,3,3,2,4,1}, shuffle(new int[]{1,2,3,4,4,3,2,1}, 4));
        assertArrayEquals(new int[]{1,2,1,2}, shuffle(new int[]{1,1,2,2}, 2));
    }

    /*Example 1:

    Input: nums = [2,5,1,3,4,7], n = 3
    Output: [2,3,5,4,1,7]
    Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
    Example 2:

    Input: nums = [1,2,3,4,4,3,2,1], n = 4
    Output: [1,4,2,3,3,2,4,1]
    Example 3:

    Input: nums = [1,1,2,2], n = 2
    Output: [1,2,1,2]*/
}
