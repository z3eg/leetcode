package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/*435. Non-overlapping Intervals
        https://leetcode.com/problems/non-overlapping-intervals/*/
public class _435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        int[] overlaps = new int[10000];
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length && j != i; j++) {
                if (overlaps(intervals[i], intervals[j])) {
                    overlaps[i]++;
                }
            }
        }
        return res;
    }

    boolean overlaps(int[] a, int[] b) {
        return ((a[0] >= b[0] && a[0] < b[1])
                || (a[1] > b[0] && a[1] <= b[1])
                || (b[0] >= a[0] && b[0] < a[1])
                || (b[1] > a[0] && b[1] <= a[1])
        );
    }

    @Test
    public void testOverlaps() {
        assertFalse(overlaps(new int[]{1,2}, new int[]{2,3}));
        assertFalse(overlaps(new int[]{2,3}, new int[]{1,2}));
        assertFalse(overlaps(new int[]{1,2}, new int[]{3,4}));
        assertFalse(overlaps(new int[]{3,4}, new int[]{1,2}));
        assertFalse(overlaps(new int[]{-4,-1}, new int[]{-1,1}));
        assertFalse(overlaps(new int[]{-5,-3}, new int[]{-7,-6}));
        assertFalse(overlaps(new int[]{-5,-3}, new int[]{-7,-5}));
        assertTrue(overlaps(new int[]{-5,-3}, new int[]{-4,-2}));
        assertTrue(overlaps(new int[]{-10,-1}, new int[]{-9,-2}));
        assertTrue(overlaps(new int[]{-10,-1}, new int[]{-10,-1}));
        assertTrue(overlaps(new int[]{1,2}, new int[]{1,2}));
        assertTrue(overlaps(new int[]{1,3}, new int[]{2,4}));
        assertTrue(overlaps(new int[]{1,5}, new int[]{2,4}));
        assertTrue(overlaps(new int[]{1,5}, new int[]{0,6}));
        assertTrue(overlaps(new int[]{1,5}, new int[]{0,2}));
    }

    @Test
    public void test() {
        assertEquals(1, eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
        assertEquals(2, eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));
        assertEquals(0, eraseOverlapIntervals(new int[][]{{1,2},{2,3}}));
    }
}
