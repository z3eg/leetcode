package com.company;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/unique-paths-iii/
public class _980_UniquePathsIII {

    /*16ms
    Beats 8.05%of users with Java*/
    class Cell {
        public int val;
    }

    public int uniquePathsIII(int[][] grid) {
        int obstCount = 0;
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==-1)
                    obstCount++;
                if (grid[i][j]==1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        int cellCounts = grid.length* grid[0].length - obstCount;
        Cell cell = new Cell();
        traverse(grid, startRow, startCol, 1, new LinkedList<>(), cellCounts, cell);
        return cell.val;
    }

    void traverse(int[][] grid, int row, int col, int curLen, List<String> visited, int pathLen, Cell pathCount) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return;
        if (curLen > pathLen)
            return;
        if (visited.contains(row+"_"+col))
            return;
        if (grid[row][col]==-1)
            return;
        if (grid[row][col]==2) {
            if (curLen == pathLen) {
                pathCount.val+= 1;
            }
            return;
        }
        List<String> newVisited = new LinkedList<>(visited);
        newVisited.add(row+"_"+col);
        curLen++;
        traverse(grid, row+1, col, curLen, newVisited, pathLen, pathCount);
        traverse(grid, row-1, col, curLen, newVisited, pathLen, pathCount);
        traverse(grid, row, col+1, curLen, newVisited, pathLen, pathCount);
        traverse(grid, row, col-1, curLen, newVisited, pathLen, pathCount);
    }


    @Test
    public void test() {
        assertEquals(2, uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
        assertEquals(4, uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}}));
        assertEquals(0, uniquePathsIII(new int[][]{{0,1},{2,0}}));
    }
}
