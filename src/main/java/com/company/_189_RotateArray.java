package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class _189_RotateArray {

    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        int[] rightPart = new int[k];
        int j = 0;
        for (int i = nums.length-k; i < nums.length; i++) {
            rightPart[j] = nums[i];
            j++;
        }
        for (int i = nums.length-1; i>=k; i--) {
            nums[i] = nums[i-k];
        }
        for (int i = 0; i < rightPart.length; i++) {
            nums[i] = rightPart[i];
        }
    }

    //this works, but not the most optimal way
    /*public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        int[] leftPart = new int[nums.length - k];
        int[] rightPart = new int[k];
        for (int i = 0; i < leftPart.length; i++) {
            leftPart[i] = nums[i];
        }
        for (int i = 0; i < rightPart.length; i++) {
            rightPart[i] = nums[i+leftPart.length];
        }
        for (int i = 0; i < rightPart.length; i++) {
            nums[i] = rightPart[i];
        }
        for (int i = 0; i < leftPart.length; i++) {
            nums[i+rightPart.length] = leftPart[i];
        }
    }*/

    @Test
    public void test() {
        int[] arr = {1,2,3,4,5,6,7};
        int[] res = {5,6,7,1,2,3,4};
        int k = 3;
        int[] arr2 = {-1,-100,3,99};
        int[] res2 = {3,99,-1,-100};
        int k2 = 2;
        rotate(arr,k);
        rotate(arr2,k2);
        System.out.println(Arrays.toString(arr));
        assertArrayEquals(res, arr);
        System.out.println(Arrays.toString(arr2));
        assertArrayEquals(res2, arr2);
    }
}
