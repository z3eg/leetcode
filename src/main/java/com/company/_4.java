package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*4. Median of Two Sorted Arrays
        https://leetcode.com/problems/median-of-two-sorted-arrays/description/?envType=daily-question&envId=2023-09-21*/
public class _4 {

    /*2ms
    Beats 72.12%of users with Java*/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i1 = 0;
        int i2 = 0;
        int i = 0;
        while (i1<nums1.length && i2<nums2.length) {
            if (nums1[i1]<nums2[i2]) {
                merged[i] = nums1[i1];
                i1++;
            }
            else {
                merged[i] = nums2[i2];
                i2++;
            }
            i++;
        }
        int[] rest;
        int restIdx;
        if (i1== nums1.length) {
            rest = nums2;
            restIdx = i2;
        }
        else {
            rest = nums1;
            restIdx = i1;
        }
        for (int j = i; j < merged.length; j++) {
            merged[j] = rest[restIdx];
            restIdx++;
        }
        int middle = merged.length / 2;
        if (merged.length%2==0)
            return (double) (merged[middle] + merged[middle - 1]) /2;
        else
            return merged[middle];
    }

    @Test
    public void test() {
//        assertEquals(2, findMedianSortedArrays(new int[]{1,3}, new int[]{0,2,5}),0);
        assertEquals(1.5, findMedianSortedArrays(new int[]{1,2}, new int[]{}),0);
        assertEquals(3.5, findMedianSortedArrays(new int[]{}, new int[]{3,4}),0);
        assertEquals(2.5, findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}),0);
        assertEquals(2, findMedianSortedArrays(new int[]{1,3}, new int[]{2}),0);
    }
}
