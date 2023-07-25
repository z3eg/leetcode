package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*852. Peak Index in a Mountain Array
        https://leetcode.com/problems/peak-index-in-a-mountain-array/description/*/
public class _852 {
    /*-ms
    Beats 100.00%of users with Java*/
    public int peakIndexInMountainArray(int[] arr) {
        //use binary search?
        return getIndex(arr, 0, arr.length-1);
    }

    int getIndex(int[] arr, int l, int r) {
        int mid = (r+l)/2;
        if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
            return mid;
        if (arr[mid] < arr[mid-1])
            return getIndex(arr, l, mid);
        if (arr[mid] < arr[mid+1])
            return getIndex(arr, mid, r);
        return -1;
    }

    @Test
    public void test() {
        assertEquals(3, peakIndexInMountainArray(new int[]{0,4,7,10,5,2}));
        assertEquals(3, peakIndexInMountainArray(new int[]{0,4,7,10,6,5,2}));
        assertEquals(1, peakIndexInMountainArray(new int[]{0,1,0}));
        assertEquals(1, peakIndexInMountainArray(new int[]{0,2,1,0}));
        assertEquals(1, peakIndexInMountainArray(new int[]{0,10,5,2}));
    }
}
