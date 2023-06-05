package com.company;

/*
https://leetcode.com/problems/rearrange-array-elements-by-sign/
        2149. Rearrange Array Elements by Sign
*/

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class _2149 {

    public int[] rearrangeArray(int[] nums) {
        int halfN = nums.length / 2;
        int [] positives = new int[halfN];
        int [] negatives = new int[halfN];
        int posN = 0;
        int negN = 0;
        for (int n : nums) {
            if (n>0) {
                positives[posN] = n;
                posN++;
            }
            else {
                negatives[negN] = n;
                negN++;
            }
        }
        for (int i = 0; i < halfN; i++) {
            nums[i*2] = positives[i];
            nums[i*2+1] = negatives[i];
        }
        return nums;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{3,-2,1,-5,2,-4}, rearrangeArray(new int[] {3,1,-2,-5,2,-4}));
        assertArrayEquals(new int[]{1,-1}, rearrangeArray(new int[] {-1,1}));
    }
}
