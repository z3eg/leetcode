package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

/*34. Find First and Last Position of Element in Sorted Array
        https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=daily-question&envId=2023-10-09*/
public class _34 {

    /*0ms
    Beats 100.00%of users with Java*/
    public int[] searchRange(int[] nums, int target) {
        if (nums.length==0)
            return new int[]{-1,-1};
        int[] res = new int[2];
        if (nums[0] == target)
            res[0] = 0;
        else
            res[0] = searchLeft(nums, target, 0, nums.length);
        if (nums[nums.length-1] == target)
            res[1] = nums.length-1;
        else
            res[1] = searchRight(nums, target, 0, nums.length);
        if (res[1] == -1)
            res[1] = res[0];
        return res;
    }

    private int searchLeft(int[] nums, int target, int l, int r) {
        if (r-l<=1)
            return -1;
        int mid = (l+r)/2;
        if (nums[mid]==target && (mid == 0 || nums[mid-1]!=target))
            return mid;
        if (nums[mid] > target || (nums[mid]==target && nums[mid-1] == target))
            return searchLeft(nums, target, l, mid);
        if (nums[mid] < target)
            return searchLeft(nums, target, mid, r);
        return -1;
    }

    private int searchRight(int[] nums, int target, int l, int r) {
        if (r-l<=1)
            return -1;
        int mid = (l+r)/2;
        if (nums[mid]==target && (mid > nums.length-1 || nums[mid+1]!=target))
            return mid;
        if (nums[mid] > target)
            return searchRight(nums, target, l, mid);
        if (nums[mid] < target || (nums[mid]==target && nums[mid+1] == target))
            return searchRight(nums, target, mid, r);
        return -1;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{3,4}, searchRange(new int[]{5,7,7,8,8,10},8));
        assertArrayEquals(new int[]{-1,-1}, searchRange(new int[]{5,7,7,8,8,10},6));
        assertArrayEquals(new int[]{-1,-1}, searchRange(new int[]{},0));
        assertArrayEquals(new int[]{0,0}, searchRange(new int[]{1},1));
    }
}
