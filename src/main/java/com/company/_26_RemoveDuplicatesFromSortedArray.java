package com.company;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class _26_RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        for (int i = 1; i < size; i++) {
            while (nums[i]==nums[i-1]) {
                for (int j = i-1; j < size-1; j++) {
                    nums[j] = nums[j+1];
                }
                size--;
            }
        }
        return size;
    }

}
