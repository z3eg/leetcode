package com.company;

import org.junit.jupiter.api.Test;

import java.util.*;

public class _542_01Matrix {

    /*public int[][] updateMatrix(int[][] mat) {
        int height = mat.length;
        int width = mat[0].length;
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j]!=0)
                    res[i][j] = lookAround(i, j, mat, res);
            }
        }
        return res;
    }

    int lookAround(int i, int j, int[][] mat, int[][]res) {

        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length)
            return Integer.MAX_VALUE;

        int top = Integer.MAX_VALUE;
        int bot = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        //top
        if (i > 0) {
            if (mat[i-1][j]==0) {
                return 1;
            }
            else if (res[i-1][j]!=0) {
                top = res[i-1][j]+1;
            }
        }
        //bottom
        if (i < mat.length-1) {
            if (mat[i+1][j]==0) {
                return 1;
            }
            else if (res[i+1][j]!=0) {
                bot = res[i+1][j]+1;
            }
        }
        //right
        if (j < mat[0].length-1) {
            if (mat[i][j+1]==0) {
                return 1;
            }
            else if (res[i][j+1]!=0) {
                right = res[i][j+1]+1;
            }
        }
        //left
        if (j > 0) {
            if (mat[i][j-1]==0) {
                return 1;
            }
            else if (res[i][j-1]!=0) {
                right = res[i][j-1]+1;
            }
        }
        int lowest = Math.min(top,bot);
        lowest = Math.min(lowest, left);
        lowest = Math.min(lowest, right);
        if (lowest == Integer.MAX_VALUE) {
            lowest = Math.min(lowest, lookAround(i+1, j, mat, res)+1);
            lowest = Math.min(lowest, lookAround(i-1, j, mat, res)+1);
            lowest = Math.min(lowest, lookAround(i, j-1, mat, res)+1);
            lowest = Math.min(lowest, lookAround(i, j+1, mat, res)+1);
        }
        return lowest;
    }*/

   /* 31ms
    Beats 8.25%of users with Java*/
    public int[][] updateMatrix(int[][] mat) {
        int height = mat.length;
        int width = mat[0].length;
        int[][] res = new int[mat.length][mat[0].length];
        Queue<int[]> cellQ = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j]==0) {
                    List<int[]> existingNeighbors = getExistingNeighbors(mat, i, j);
                    for (int[] neighbor : existingNeighbors) {
                        if (mat[neighbor[0]][neighbor[1]]!=0) {
                            res[neighbor[0]][neighbor[1]] = 1;
                            cellQ.add(neighbor);
                        }
                    }
                }
                else {
                    if (res[i][j]!=1) {
                        res[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        while (!cellQ.isEmpty()) {
            int[] curCell = cellQ.poll();
            int curI = curCell[0];
            int curJ = curCell[1];
            int curCellVal = res[curI][curJ];
            List<int[]> existingNeighbors = getExistingNeighbors(mat, curI, curJ);
            for (int[] neighbor : existingNeighbors)
                if (res[neighbor[0]][neighbor[1]]>curCellVal+1) {
                    res[neighbor[0]][neighbor[1]] = curCellVal+1;
                    cellQ.add(neighbor);
                }
        }
        return res;
    }

    List<int[]> getExistingNeighbors(int[][] mat, int i, int j) {
        List<int[]> res = new LinkedList<>();
        if (i > 0)
            res.add(new int[]{i-1, j});
        if (j > 0)
            res.add(new int[]{i, j-1});
        if (i < mat.length-1)
            res.add(new int[]{i+1, j});
        if (j < mat[0].length-1)
            res.add(new int[]{i, j+1});
        return res;
    }

    @Test
    public void test() {
//        int[][] mat = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
//        int[][] mat = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
//        int[][] mat = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
//        int[][] mat = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
        int[][] mat = new int[][]{{0,1,1},{1,1,1},{1,1,1}};
        int[][] res = updateMatrix(mat);
        System.out.println(res);
    }


}
