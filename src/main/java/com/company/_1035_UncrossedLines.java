package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/uncrossed-lines/
public class _1035_UncrossedLines {

    //not working
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return Math.max(maLines(nums1, nums2), maLines(nums2, nums1));
    }

    int maLines(int[] nums1, int[]nums2) {
        int count = 0;
        int start = 0;
        int finish = nums2.length-1;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = start; j <= finish; j++) {
                if (nums1[i]==nums2[j]) {
                    count++;
                    start = j+1;
                    break;
                }
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(5, maxUncrossedLines(new int[] {1,1,3,5,3,3,5,5,1,1}, new int[]{2,3,2,1,3,5,3,2,2,1}));
        assertEquals(3, maxUncrossedLines(new int[] {2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
        assertEquals(2, maxUncrossedLines(new int[] {1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
    }
}
