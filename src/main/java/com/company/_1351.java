package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*1351. Count Negative Numbers in a Sorted Matrix
        https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/*/
public class _1351 {
    public int countNegatives(int[][] grid) {
        int res = 0;
        int right = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < right; j++) {
                if (grid[i][j]<0) {
                    res+= grid.length-i;
                    res+= right-j-1;
                    right--;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(8, countNegatives(new int[][]{{4,3,2,-1},
                                                            {3,2,1,-1},
                                                            {1,1,-1,-2},
                                                            {-1,-1,-2,-3}}));
        assertEquals(0, countNegatives(new int[][]{{3,2},{1,0}}));
    }
}
