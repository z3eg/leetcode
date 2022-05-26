package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/search-insert-position/
public class _35_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int pos=left+(right-left)/2;
        while ((right-left)>0 && target != nums[pos]) {
            if (right-left == 1) {
                return (target>nums[pos]?pos+1:pos);
            }
            if (target>nums[pos]) {
                left = pos;
            }
            if (target<nums[pos]) {
                right = pos;
            }
            pos = left+(int)Math.floor((double)(right-left)/2);
        }
        return pos;
    }

    @Test
    public void test() {
        assertEquals(0,searchInsert(new int[]{1,3,5,6},0));
        assertEquals(2,searchInsert(new int[]{1,3,5,6},5));
        assertEquals(1,searchInsert(new int[]{1,3,5,6},2));
        assertEquals(4,searchInsert(new int[]{1,3,5,6},7));
    }
}
