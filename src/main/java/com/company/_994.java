package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

//87.16%
public class _994 {

    private class Cell{
        int x;
        int y;
        public Cell(int x, int y) {
            this.x = x;
            this.y = y;;
        }
    }
    public int orangesRotting(int[][] grid) {
        int rounds = 0;
        Queue<Cell> q = new LinkedList<>();
        int fresh = 0;
        //adding rotting oranges to q initially
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (isOrange(grid, i,j) && isIsolated(grid, i, j))
                    return -1;
                if (grid[i][j]==2)
                    q.add(new Cell(i,j));
                if (grid[i][j]==1)
                    fresh++;
            }
        }
        if (fresh == 0)
            return 0;
        while (!q.isEmpty()) {
            rounds++;
            //pull all from the q, process and bump up the rounds counter
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Cell curCell = q.poll();
                rotAround(grid,curCell.x, curCell.y, q);
            }
        }
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1)
                    return -1;
            }
        }
        return rounds-1;
    }

    public boolean isOrange(int[][] grid, int x, int y) {
        if (x < 0 || x >=grid.length)
            return false;
        if (y < 0 || y >= grid[0].length)
            return false;
        return grid[x][y] == 1;
    }

    public boolean isRotten(int[][] grid, int x, int y) {
        if (x < 0 || x >=grid.length)
            return false;
        if (y < 0 || y >= grid[0].length)
            return false;
        return grid[x][y] == 2;
    }

    public boolean isIsolated(int[][] grid, int x, int y) {
        if (isOrange(grid, x+1, y) || isRotten(grid, x+1, y))
            return false;
        if (isOrange(grid, x-1, y) || isRotten(grid, x-1, y))
            return false;
        if (isOrange(grid, x, y+1) || isRotten(grid, x, y+1))
            return false;
        if (isOrange(grid, x, y-1) || isRotten(grid, x, y-1))
            return false;
        return true;
    }

    public void rotAround(int[][] grid, int x, int y, Queue q) {
        if (x < 0 || x >=grid.length)
            return;
        if (y < 0 || y >= grid[0].length)
            return;
        rot(grid,x+1,y,q);
        rot(grid,x-1,y,q);
        rot(grid,x,y+1,q);
        rot(grid,x,y-1,q);
    }

    public void rot(int[][] grid, int x, int y, Queue q) {
        if (x < 0 || x >=grid.length)
            return;
        if (y < 0 || y >= grid[0].length)
            return;
        if (grid[x][y]==1) {
            grid[x][y] = 2;
            q.add(new Cell(x,y));
        }
    }

    @Test
    public void test() {

        assertEquals(-1, orangesRotting(new int[][] {{2,2,1,0,1,1}}));
        assertEquals(2, orangesRotting(new int[][] {{2,1,1},
                {1,1,1},
                {0,1,2}}));
        assertEquals(1, orangesRotting(new int[][] {{1,2}}));
        assertEquals(4, orangesRotting(new int[][] {{2,1,1},
                                                            {1,1,0},
                                                            {0,1,1}}));

        assertEquals(-1, orangesRotting(new int[][] {{2,1,1},
                                                              {0,1,1},
                                                              {1,0,1}}));
        assertEquals(0, orangesRotting(new int[][] {{0,2}}));
    }
}
