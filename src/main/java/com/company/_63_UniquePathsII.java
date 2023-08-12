package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/unique-paths-ii/
public class _63_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int maxX = obstacleGrid[0].length-1;
        int maxY = obstacleGrid.length-1;
        return takeAStep(obstacleGrid, 0, 0, 0, maxX, maxY);
    }

    int takeAStep(int[][] grid, int curX, int curY, int total, int maxX, int maxY) {
        if (curX == maxX && curY == maxY)
            return ++total;
        if (curX+1 <= maxX && grid[curY][curX+1]!=1)
            total = takeAStep(grid, curX+1, curY, total, maxX, maxY);
        if (curY+1 <= maxY && grid[curY+1][curX]!=1)
            total = takeAStep(grid, curX, curY+1, total, maxX, maxY);
        return total;
    }

    @Test
    public void test() {
        assertEquals(1, uniquePathsWithObstacles(new int[][]{{0}}));
        assertEquals(1, uniquePathsWithObstacles(new int[][]{{0,0}}));
        assertEquals(2, uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        assertEquals(1, uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
    }
}
