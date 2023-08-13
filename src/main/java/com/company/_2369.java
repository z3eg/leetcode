package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
public class _2369 {


//54 / 117 testcases passed
    public boolean validPartition(int[] nums) {
        return validPartition(nums, 0);
    }

    boolean validPartition(int[] nums, int pos) {
        if (pos == nums.length)
            return true;
        if (pos > nums.length-2)
            return false;
        if (pos <= nums.length-3 && ((nums[pos]==nums[pos+1] && nums[pos+1]==nums[pos+2]) ||
                (nums[pos]==nums[pos+1]-1 && nums[pos+1]==nums[pos+2]-1))) {
            if (validPartition(nums, pos+3))
                return true;
        }
        if (nums[pos]==nums[pos+1] && (validPartition(nums, pos+2)))
            if (validPartition(nums, pos+2))
                return true;
        return false;
    }

    @Test
    public void test() {
        assertTrue(validPartition(new int[]{4,4,5,5}));
        assertTrue(validPartition(new int[]{4,4,4,5,6}));
        assertFalse(validPartition(new int[]{1,1,1,2}));
        assertTrue(validPartition(new int[]{1,1}));
        assertTrue(validPartition(new int[]{1,2,3}));
        assertTrue(validPartition(new int[]{3,3,3}));
        assertTrue(validPartition(new int[]{3,4,5,1,1}));
        assertTrue(validPartition(new int[]{3,4,5,1,1,1}));
    }
}
