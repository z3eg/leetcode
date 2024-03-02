package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

public class _977 {

    /*13
    ms
            Beats
8.51%
    of users with Java*/
    /*public int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums).boxed().mapToInt(i -> i*i).sorted().toArray();
    }*/

    /*438
    ms
            Beats
5.01%
    of users with Java*/
    public int[] sortedSquares(int[] nums) {
        boolean sorted = false;
        for (int i = 0; i < nums.length; i++) {
            nums[i]*=nums[i];
        }
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < nums.length-1; i++) {
                if (nums[i] > nums[i+1]) {
                    sorted = false;
                    int tmp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = tmp;
                }
            }
        }
        return nums;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{0,1,9,16,100}, sortedSquares(new int[]{-4,-1,0,3,10}));
        assertArrayEquals(new int[]{4,9,9,49,121}, sortedSquares(new int[]{-7,-3,2,3,11}));
    }
}
