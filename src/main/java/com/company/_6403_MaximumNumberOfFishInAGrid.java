package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _6403_MaximumNumberOfFishInAGrid {

    public int findMaxFish(int[][] grid) {
        int max = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean[][] visited = new boolean[rows][cols];
                int sum = fish(grid, visited, rows, cols, i, j, 0);
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public int fish(int[][] grid, boolean[][]visited, int rows, int cols, int r, int c, int sum) {
        if (r<rows && r>=0 && c<cols && c>=0 && grid[r][c]!=0) {
            sum+=grid[r][c];
            visited[r][c] = true;
            //move up
            if (r-1 >= 0 && grid[r-1][c]!=0 && !visited[r-1][c])
                sum=fish(grid, visited, rows, cols, r-1, c, sum);
            //move down
            if (r+1 < rows && grid[r+1][c]!=0 && !visited[r+1][c])
                sum=fish(grid, visited, rows, cols, r+1, c, sum);
            //move left
            if (c-1 >= 0 && grid[r][c-1]!=0 && !visited[r][c-1])
                sum=fish(grid, visited, rows, cols, r, c-1, sum);
            //move right
            if (c+1 < cols && grid[r][c+1]!=0 && !visited[r][c+1])
                sum=fish(grid, visited, rows, cols, r, c+1, sum);
            return sum;
        }
        return 0;
    }

    @Test
    public void test() {
        int[][] grid0 = {{0, 5}, {8,4}};
        assertEquals(17, findMaxFish(grid0));
        int[][] grid = {{0, 2, 1, 0}, {4, 0, 0, 3}, {1, 0, 0, 4}, {0, 3, 2, 0}};
        assertEquals(7, findMaxFish(grid));
        int[][] grid2 = {{1,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,1}};
        assertEquals(1, findMaxFish(grid2));
    }
}
