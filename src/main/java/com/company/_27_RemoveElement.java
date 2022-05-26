package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/remove-element/
public class _27_RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums.length==0) {
            return 0;
        }
        int shift = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            while (nums[i]==val) {
                shift++;
                for (int j = i; j < size-1; j++) {
                    nums[j] = nums[j+1];
                }
                nums[size-shift] = val-1;
            }
        }
        return size-shift;
    }

    @Test
    public void test() {
        assertEquals(0,removeElement(new int[]{},0));
        assertEquals(1,removeElement(new int[]{2},3));
        assertEquals(2,removeElement(new int[]{3,2,2,3},3));
        assertEquals(5,removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }
}
