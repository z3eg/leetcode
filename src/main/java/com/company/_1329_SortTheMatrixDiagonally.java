package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class _1329_SortTheMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {
        int matHeight = mat.length;
        int matWidth = mat[0].length;
        boolean sorted;
        for (int i = 0; i < matWidth-1; i++) {
            sorted = false;
            while (!sorted) {
                sorted = sortDiagonalOf(mat, matHeight, matWidth, i, 0);
            }
        }
        for (int i = 1; i < matHeight-1; i++) {
            sorted = false;
            while (!sorted) {
                sorted = sortDiagonalOf(mat, matHeight, matWidth, 0, i);
            }
        }
        return mat;
    }

    private boolean sortDiagonalOf(int[][] mat, int matHeight, int matWidth, int startingX, int startingY) {
        boolean sorted = true;
        while (startingY < matHeight -1 && startingX < matWidth -1) {
            if (mat[startingY][startingX] > mat[startingY +1][startingX +1]) {
                int tmp = mat[startingY][startingX];
                mat[startingY][startingX] = mat[startingY +1][startingX +1];
                mat[startingY +1][startingX +1] = tmp;
                sorted = false;
            }
            startingX++;
            startingY++;
        }
        return sorted;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[][]{{1,1,1,1},
                                      {1,2,2,2},
                                      {1,2,3,3}},
                diagonalSort(new int[][]{{3,3,1,1},
                                         {2,2,1,2},
                                         {1,1,1,2}}));

        assertArrayEquals(new int[][]{{5,17,4,1,52,7},
                                      {11,11,25,45,8,69},
                                      {14,23,25,44,58,15},
                                      {22,27,31,36,50,66},
                                      {84,28,75,33,55,68}},
                diagonalSort(new int[][]{{11,25,66,1,69,7},
                                         {23,55,17,45,15,52},
                                         {75,31,36,44,58,8},
                                         {22,27,33,25,68,4},
                                         {84,28,14,11,5,50}}));
    }
}
