package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _2500 {

    public int deleteGreatestValue(int[][] grid) {
        for (int[] row : grid) {
            Arrays.sort(row);
        }
        int sum = 0;
        for (int i = grid[0].length-1; i >= 0 ; i--) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            sum+=max;
        }
        return sum;
    }

    @Test
    public void test() {
        assertEquals(8, deleteGreatestValue(new int[][]{{1,2,4},{3,3,1}}));
        assertEquals(10, deleteGreatestValue(new int[][]{{10}}));
    }
}
