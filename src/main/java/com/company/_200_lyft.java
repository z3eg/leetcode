package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _200_lyft {

    public int numIslands(char[][] grid) {
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]=='1') {
                    counter++;
                    takeOver(grid, i, j);
                }
            }
        }
        return counter;
    }

    public void takeOver(char[][] grid, int x, int y) {
        if (x<0 || x>=grid.length)
            return;
        if (y<0 || y>=grid[0].length)
            return;
        if (grid[x][y]=='2')
            return;
        if (grid[x][y]=='0')
            return;
        grid[x][y] = '2';
        takeOver(grid, x+1, y);
        takeOver(grid, x-1, y);
        takeOver(grid, x, y+1);
        takeOver(grid, x, y-1);
    }

    @Test
    public void test() {
        assertEquals(1, numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        }));
        assertEquals(3, numIslands(new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        }));
    }

}
