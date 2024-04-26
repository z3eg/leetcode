package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _1259 {
    //dp?
    public int minFallingPathSum(int[][] grid) {
        if (grid.length==0)
            return 0;
        if (grid.length==1)
            return Arrays.stream(grid[0]).min().getAsInt();
        return 0;
    }

    @Test
    public void test() {
        assertEquals(13, minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        assertEquals(7, minFallingPathSum(new int[][]{{7}}));
    }
}
