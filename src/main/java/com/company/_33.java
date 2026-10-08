package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _33 {

    /*0
ms
Beats
100.00%
*/
    public int search(int[] nums, int target) {
        int cutOff = -1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]>nums[i+1]) {
                cutOff = i;
                break;
            }
        }
        if (cutOff == -1) {
            //array not rotated, binary search full array
            return bs(nums, target, 0, nums.length-1);
        }
        else
        {
            //array rotated, bs in both parts (potentially checking which part target belongs to as an optimization
            int res = bs(nums, target, 0, cutOff);
            if (res!=-1) {
                return res;
            }
            return bs(nums, target, cutOff, nums.length-1);
        }
    }

    int bs(int[] nums, int target, int l, int r) {
        if (r-l<2)
            return (nums[r]==target)?r:(nums[l]==target?l:-1);
        int mid = (r+l)/2;
        if (target==nums[mid])
            return mid;
        if (target<nums[mid])
            return bs(nums, target, l,mid);
        else
            return bs(nums, target, mid,r);
    }

    @Test
    public void testBS() {
        assertEquals(0, bs(new int[]{1,3,5}, 1, 0, 2));
        assertEquals(1, bs(new int[]{1,3,5}, 3, 0, 2));
    }


}
