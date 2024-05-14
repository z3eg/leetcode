package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1219 {

    /*Wrong Answer
43 / 55 testcases passed*/
    /*public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, getGold(0, grid, new boolean[grid.length][grid[0].length], i, j));
            }
        }
        return max;
    }

    int getGold(int curGold, int[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= grid.length)
            return curGold;
        if (c < 0 || c >= grid[0].length)
            return curGold;
        if (visited[r][c])
            return curGold;
        if (grid[r][c]==0)
            return curGold;
        curGold+=grid[r][c];
        int maxGold = curGold;
        visited[r][c] = true;
        maxGold=Math.max(maxGold,getGold(curGold, grid, visited, r+1,c));
        maxGold=Math.max(maxGold,getGold(curGold, grid, visited, r-1,c));
        maxGold=Math.max(maxGold,getGold(curGold, grid, visited, r,c+1));
        maxGold=Math.max(maxGold,getGold(curGold, grid, visited, r,c-1));
        return maxGold;
    }*/


    /*70
    ms
    Beats
    57.60%
    of users with Java*/
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, getGold(0, grid, new boolean[grid.length][grid[0].length], i, j));
            }
        }
        return max;
    }

    int getGold(int curGold, int[][] grid, boolean[][] visited, int r, int c) {
        if (r < 0 || r >= grid.length)
            return curGold;
        if (c < 0 || c >= grid[0].length)
            return curGold;
        if (visited[r][c])
            return curGold;
        if (grid[r][c]==0)
            return curGold;
        curGold+=grid[r][c];
        int maxGold = curGold;
        visited[r][c] = true;
        maxGold=Math.max(maxGold,getGold(curGold, grid, visited, r+1,c));
        maxGold=Math.max(maxGold,getGold(curGold, grid, visited, r-1,c));
        maxGold=Math.max(maxGold,getGold(curGold, grid, visited, r,c+1));
        maxGold=Math.max(maxGold,getGold(curGold, grid, visited, r,c-1));
        visited[r][c] = false;
        return maxGold;
    }

    @Test
    public void test() {
        assertEquals(24, getMaximumGold(new int[][]{{0,6,0},{5,8,7},{0,9,0}}));
        assertEquals(28, getMaximumGold(new int[][]{{1,0,7}, {2,0,6},{3,4,5},{0,3,0},{9,0,20}}));
    }
}
