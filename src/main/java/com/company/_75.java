package com.company;

import org.junit.Test;

import java.util.Arrays;

public class _75 {

    /*2
    ms
    Beats
    12.93%
    of users with Java*/
    public void sortColors(int[] nums) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < nums.length-1; i++) {
                if (nums[i] > nums[i+1]) {
                    int tmp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = tmp;
                    sorted = false;
                }
            }
        }
    }

    @Test
    public void test() {
        sortColors(new int[]{2,0,2,1,1,0});
    }

}
