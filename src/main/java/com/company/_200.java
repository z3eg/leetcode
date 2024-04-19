package com.company;

public class _200 {

    /*3
    ms
    Beats
    86.63%
    of users with Java*/
    public int numIslands(char[][] grid) {
        boolean[][] marked = new boolean[grid.length][grid[0].length];
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!marked[i][j] && grid[i][j]=='1') {
                    counter++;
                    markAdjacent(grid, marked, i, j);
                }
            }
        }
        return counter;
    }

    private void markAdjacent(char[][] grid, boolean[][] marked, int i, int j) {
        if (!marked[i][j] && grid[i][j]=='1') {
            marked[i][j]=true;
            if (i-1>=0 && grid[i-1][j]!='0' && !marked[i-1][j]) {
                markAdjacent(grid, marked, i-1, j);
            }
            if (i+1<grid.length && grid[i+1][j]!='0' && !marked[i+1][j]) {
                markAdjacent(grid, marked, i+1, j);
            }
            if (j+1<grid[i].length && grid[i][j+1]!='0' && !marked[i][j+1]) {
                markAdjacent(grid, marked, i, j+1);
            }
            if (j-1>=0 && grid[i][j-1]!='0' && !marked[i][j-1]) {
                markAdjacent(grid, marked, i, j-1);
            }
        }
    }
}
