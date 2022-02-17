package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/4sum-ii/
public class _454_4Sum_II {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int counter = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);
        //impl
        return 0;
    }


    //the most obvious soultion, TLE
    /*public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int counter = 0;
        if (n==1) {
            return (nums1[0]+nums2[0]+nums3[0]+nums4[0]==0) ? 1: 0;
        }
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n; l++) {
                            if (nums1[i]+nums2[j]+nums3[k]+nums4[l]==0) {
                                counter++;
                            }
                        }
                    }
                }
            }
        }
        return counter;
    }*/


    @Test
    public void test() {
        assertEquals(2,fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}));
        assertEquals(1,fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}));
        assertEquals(0,fourSumCount(new int[]{0}, new int[]{1}, new int[]{0}, new int[]{0}));
    }

}
