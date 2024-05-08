package com.company;

import org.junit.jupiter.api.Test;

import java.util.*;

public class _542_01Matrix {

    /*public int[][] updateMatrix(int[][] mat) {
        int height = mat.length;
        int width = mat[0].length;
        int[][] mat = new int[mat.length][mat[0].length];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j]!=0)
                    mat[i][j] = lookAround(i, j, mat, mat);
            }
        }
        return mat;
    }

    int lookAround(int i, int j, int[][] mat, int[][]mat) {

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
            else if (mat[i-1][j]!=0) {
                top = mat[i-1][j]+1;
            }
        }
        //bottom
        if (i < mat.length-1) {
            if (mat[i+1][j]==0) {
                return 1;
            }
            else if (mat[i+1][j]!=0) {
                bot = mat[i+1][j]+1;
            }
        }
        //right
        if (j < mat[0].length-1) {
            if (mat[i][j+1]==0) {
                return 1;
            }
            else if (mat[i][j+1]!=0) {
                right = mat[i][j+1]+1;
            }
        }
        //left
        if (j > 0) {
            if (mat[i][j-1]==0) {
                return 1;
            }
            else if (mat[i][j-1]!=0) {
                right = mat[i][j-1]+1;
            }
        }
        int lowest = Math.min(top,bot);
        lowest = Math.min(lowest, left);
        lowest = Math.min(lowest, right);
        if (lowest == Integer.MAX_VALUE) {
            lowest = Math.min(lowest, lookAround(i+1, j, mat, mat)+1);
            lowest = Math.min(lowest, lookAround(i-1, j, mat, mat)+1);
            lowest = Math.min(lowest, lookAround(i, j-1, mat, mat)+1);
            lowest = Math.min(lowest, lookAround(i, j+1, mat, mat)+1);
        }
        return lowest;
    }*/

   /* 31ms
    Beats 8.25%of users with Java*/
    /*public int[][] updateMatrix(int[][] mat) {
        int height = mat.length;
        int width = mat[0].length;
        int[][] mat = new int[mat.length][mat[0].length];
        Queue<int[]> cellQ = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j]==0) {
                    List<int[]> existingNeighbors = getExistingNeighbors(mat, i, j);
                    for (int[] neighbor : existingNeighbors) {
                        if (mat[neighbor[0]][neighbor[1]]!=0) {
                            mat[neighbor[0]][neighbor[1]] = 1;
                            cellQ.add(neighbor);
                        }
                    }
                }
                else {
                    if (mat[i][j]!=1) {
                        mat[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        while (!cellQ.isEmpty()) {
            int[] curCell = cellQ.poll();
            int curI = curCell[0];
            int curJ = curCell[1];
            int curCellVal = mat[curI][curJ];
            List<int[]> existingNeighbors = getExistingNeighbors(mat, curI, curJ);
            for (int[] neighbor : existingNeighbors)
                if (mat[neighbor[0]][neighbor[1]]>curCellVal+1) {
                    mat[neighbor[0]][neighbor[1]] = curCellVal+1;
                    cellQ.add(neighbor);
                }
        }
        return mat;
    }

    List<int[]> getExistingNeighbors(int[][] mat, int i, int j) {
        List<int[]> mat = new LinkedList<>();
        if (i > 0)
            mat.add(new int[]{i-1, j});
        if (j > 0)
            mat.add(new int[]{i, j-1});
        if (i < mat.length-1)
            mat.add(new int[]{i+1, j});
        if (j < mat[0].length-1)
            mat.add(new int[]{i, j+1});
        return mat;
    }*/

    //same as the above but with inlined method to save some collection back and forth
    /*24ms
    Beats 12.01%of users with Java*/
    public int[][] updateMatrix(int[][] mat) {
        int height = mat.length;
        int width = mat[0].length;
        Queue<int[]> cellQ = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j]==0) {
                    int[] neighbor;
                    if (i > 0) {
                        neighbor = new int[]{i - 1, j};
                        if (mat[i - 1][j] != 0) {
                            mat[i - 1][j] = Integer.MAX_VALUE;
                            cellQ.add(neighbor);
                        }
                    }
                    if (j > 0) {
                        neighbor = new int[]{i, j-1};
                        if (mat[i][j-1] != 0) {
                            mat[i][j-1] = Integer.MAX_VALUE;
                            cellQ.add(neighbor);
                        }
                    }
                    if (i < mat.length-1) {
                        neighbor = new int[]{i+1, j};
                        if (mat[i+1][j] != 0) {
                            mat[i+1][j] = Integer.MAX_VALUE;
                            cellQ.add(neighbor);
                        }
                    }
                    if (j < mat[0].length-1) {
                        neighbor = new int[]{i, j+1};
                        if (mat[i][j+1] != 0) {
                            mat[i][j+1] = Integer.MAX_VALUE;
                            cellQ.add(neighbor);
                        }
                    }
                }
                else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!cellQ.isEmpty()) {
            int[] curCell = cellQ.poll();
            int i = curCell[0];
            int j = curCell[1];
            int curCellVal = mat[i][j];
            int[] neighbor;
            if (i > 0) {
                neighbor = new int[]{i - 1, j};
                if (mat[i - 1][j] >curCellVal+1) {
                    mat[i - 1][j] = curCellVal+1;
                    cellQ.add(neighbor);
                }
            }
            if (j > 0) {
                neighbor = new int[]{i, j-1};
                if (mat[i][j-1] >curCellVal+1) {
                    mat[i][j-1] = curCellVal+1;
                    cellQ.add(neighbor);
                }
            }
            if (i < mat.length-1) {
                neighbor = new int[]{i+1, j};
                if (mat[i+1][j] > curCellVal+1) {
                    mat[i+1][j] = curCellVal+1;
                    cellQ.add(neighbor);
                }
            }
            if (j < mat[0].length-1) {
                neighbor = new int[]{i, j+1};
                if (mat[i][j+1] > curCellVal+1) {
                    mat[i][j+1] = curCellVal+1;
                    cellQ.add(neighbor);
                }
            }
        }
        return mat;
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
