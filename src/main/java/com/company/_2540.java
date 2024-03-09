package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _2540 {
    /*2
    ms
            Beats
81.56%
    of users with Java*/
    public int getCommon(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length || p2 < nums2.length){
            if(nums1[p1] == nums2[p2])
                return nums1[p1];
            while(p1 < nums1.length-1 && nums1[p1] < nums2[p2]){
                p1++;
            }
            while(p2 < nums2.length-1 && nums1[p1] > nums2[p2]){
                p2++;
            }
            if (p1 == nums1.length-1 && nums1[p1] < nums2[p2])
                return -1;
            if (p2 == nums2.length-1 && nums2[p2] < nums1[p1])
                return -1;
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(-1, getCommon(new int[]{2}, new int[]{4}));
        assertEquals(-1, getCommon(new int[]{4}, new int[]{2}));
        assertEquals(2, getCommon(new int[]{2}, new int[]{2}));
        assertEquals(2, getCommon(new int[]{2}, new int[]{2,4}));
        assertEquals(-1, getCommon(new int[]{2,4,5}, new int[]{1}));
        assertEquals(-1, getCommon(new int[]{2,4,5}, new int[]{7}));
        assertEquals(-1, getCommon(new int[]{2}, new int[]{3,4}));
        assertEquals(2, getCommon(new int[]{1,2,3}, new int[]{2,4}));
        assertEquals(2, getCommon(new int[]{1,2,3,6}, new int[]{2,3,4,5}));
    }
}
