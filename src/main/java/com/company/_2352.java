package com.company;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*2352. Equal Row and Column Pairs
        https://leetcode.com/problems/equal-row-and-column-pairs/*/
public class _2352 {
    /*Runtime
    160 ms
    Beats
    13.38%*/
    /*public int equalPairs(int[][] grid) {
        int n = grid.length;
        String[] rows = new String[n];
        for (int i = 0; i < n; i++) {
            rows[i] = convertToString(grid[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(grid[j][i]);
                sb.append("_");
            }
            String s = sb.toString();
            for (int k = 0; k < n; k++) {
                if (s.equals(rows[k]))
                    res++;
            }
        }
        return res;
    }

    private String convertToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
            sb.append("_");
        }
        return sb.toString();
    }*/

    /*Runtime
    44 ms
    Beats
    63.67%*/
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int res = 0;
        for (int row = 0; row < n; row++) {
            outer: for (int col = 0; col < n; col++) {
                //check current row vs current col
                for (int i = 0; i < n; i++) {
                    if (grid[row][i]!=grid[i][col])
                        continue outer;
                }
                res++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(3, equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
        assertEquals(1, equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
        assertArrayEquals(new int[]{1,2,3}, new int[]{4,5,6});
    }
}
