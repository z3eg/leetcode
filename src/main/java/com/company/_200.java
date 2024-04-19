package com.company;

public class _200 {

    public int numIslands(char[][] grid) {
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!marked[i][j]) {
                    counter = markAdjacent(grid, marked, i, j, counter);
                }
            }
        }
        return counter;
    }

    private int markAdjacent(char[][] grid, boolean[][] marked, int i, int j, int counter) {
        if (i>=0 && i < grid.length && j >=0 && j < grid[i].length) {
            marked[i][j]=true;
            if (i-1>=0 && grid[i-1][j]!=0 && !marked[i-1][j]) {
                counter = markAdjacent(grid, marked, i-1, j, counter);
            }
            if (i+1<grid.length && grid[i+1][j]!=0 && !marked[i+1][j]) {
                counter = markAdjacent(grid, marked, i+1, j, counter);
            }
        }
        return counter;
    }
}
