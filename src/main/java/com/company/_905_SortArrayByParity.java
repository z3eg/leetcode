package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/sort-array-by-parity/
public class _905_SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            int startPos = 0;
            for (int i = startPos; i < nums.length-1; i++) {
                if (nums[i]%2==1 && nums[i+1]%2==0) {
                    sorted = false;
                    int tmp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = tmp;
                    startPos=i;
                }
            }
        }
        return nums;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{2,4,3,1},sortArrayByParity(new int[]{3,1,2,4}));
        assertArrayEquals(new int[]{0},sortArrayByParity(new int[]{0}));
    }
}
