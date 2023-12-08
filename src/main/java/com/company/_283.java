package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class _283 {

    //wrong implementation which moves zeroes tho
    /*public void moveZeroes(int[] nums) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < nums.length-1; i++) {
                if (nums[i]==0) {
                    int swapPos = nums.length-1;
                    while (nums[swapPos]==0 && swapPos > i) {
                        swapPos--;
                    }
                    if (swapPos>i) {
                        sorted = false;
                        nums[i] = nums[swapPos];
                        nums[swapPos] = 0;
                    }
                }
            }
        }
    }*/

    /*213
    ms
            Beats
5.04%
    of users with Java*/
    public void moveZeroes(int[] nums) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < nums.length-1; i++) {
                if (nums[i]==0 && nums[i+1]!=0) {
                    sorted = false;
                    nums[i] = nums[i+1];
                    nums[i+1] = 0;
                }
            }
        }
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        assertArrayEquals(new int[]{1,3,12,0,0}, nums);
        nums = new int[]{0};
        moveZeroes(nums);
        assertArrayEquals(new int[]{0}, nums);
    }
}
