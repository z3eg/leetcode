package com.company;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/
        2570. Merge Two 2D Arrays by Summing Values*/
public class _2570 {
    /*3ms
    Beats 50.88%of users with Java*/
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] arr : nums1) {
            map.put(arr[0],arr[1]);
        }
        for (int[] arr : nums2) {
            Integer val = map.get(arr[0]);
            if (val==null)
                val = 0;
            map.put(arr[0], val + arr[1]);
        }
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            res[i][0] = e.getKey();
            res[i][1] = e.getValue();
            i++;
        }

        return res;
    }

    /*int bs(int[][] nums, int n, int l, int r) {
        int mid = (l+r)/2;
        if (mid==l || mid == r)
            return nums[mid][0]==n?nums[mid][1]:0;
        if (n == nums[mid][0])
            return nums[mid][1];
        if (n > nums[mid][0])
            return bs(nums, n, mid, r);
        else
            return bs(nums, n, l, mid);
    }*/

    @Test
    public void test() {
        assertArrayEquals(new int[][]{{1,6},{2,3},{3,2},{4,6}}, mergeArrays(new int[][]{{1,2},{2,3},{4,5}}, new int[][]{{1,4},{3,2},{4,1}}));
    }
}
