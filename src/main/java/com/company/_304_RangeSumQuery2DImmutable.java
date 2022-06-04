package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/range-sum-query-2d-immutable/
public class _304_RangeSumQuery2DImmutable {

    static class NumMatrix {

        int[][] rowCumulativeSum;
        int[][] colCumulativeSum;
        int[][] matrix;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            int matHeight = matrix.length;
            int matWidth = matrix[0].length;
            if (matWidth > 1) {
                rowCumulativeSum = new int[matHeight][matWidth];
                for (int i = 0; i < matHeight; i++) {
                    rowCumulativeSum[i][0] = matrix[i][0];
                }
                for (int i = 0; i < matHeight; i++) {
                    for (int j = 1; j < matWidth; j++) {
                        rowCumulativeSum[i][j] = rowCumulativeSum[i][j-1] + matrix[i][j];
                    }
                }
            }
            if (matHeight>1) {
                colCumulativeSum = new int[matHeight][matWidth];
                System.arraycopy(matrix[0], 0, colCumulativeSum[0], 0, matWidth);
                for (int i = 1; i < matHeight; i++) {
                    for (int j = 0; j < matWidth; j++) {
                        colCumulativeSum[i][j] = colCumulativeSum[i-1][j] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1==row2 && col1==col2) {
                return matrix[row1][col1];
            }
            int sum = 0;
            if (row1==row2) {
                return rowCumulativeSum[row1][col2]-((col1==0)?0:rowCumulativeSum[row1][col1-1]);
            }
            if (col1==col2) {
                return colCumulativeSum[row2][col1]-((row1==0)?0:colCumulativeSum[row1-1][col1]);
            }
            if (row2-row1>col2-col1) {
                for (int i = col1; i <= col2; i++) {
                    sum+=colCumulativeSum[row2][i]-((row1==0)?0:colCumulativeSum[row1-1][i]);
                }
            }
            else {
                for (int i = row1; i <= row2; i++) {
                    sum+=rowCumulativeSum[i][col2]-((col1==0)?0:rowCumulativeSum[i][col1-1]);
                }
            }
            return sum;
        }
    }

    @Test
    public void test() {
        NumMatrix col2 = new NumMatrix(new int[][]{
                {-4},{-5}
        });
        assertEquals(-9, col2.sumRegion(0,0,1,0));
        assertEquals(-4, col2.sumRegion(0,0,0,0));
        assertEquals(-5, col2.sumRegion(1,0,1,0));
        NumMatrix row2 = new NumMatrix(new int[][]{
                {-4,-5}
        });
        assertEquals(-9, row2.sumRegion(0,0,0,1));
        assertEquals(-4, row2.sumRegion(0,0,0,0));
        assertEquals(-5, row2.sumRegion(0,1,0,1));
        NumMatrix col = new NumMatrix(new int[][]{
                {3},
                {0},
                {1},
                {4},
                {2}
        });
        assertEquals(5, col.sumRegion(1,0,3,0));
        NumMatrix row = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2}
        });
        assertEquals(5, row.sumRegion(0,1,0,3));
        NumMatrix minusOne = new NumMatrix((new int[][]{{-1}}));
        assertEquals(-1, minusOne.sumRegion(0,0,0,0));
        NumMatrix obj = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
        assertEquals(8, obj.sumRegion(2,1,4,3));
        assertEquals(11, obj.sumRegion(1, 1, 2, 2));
        assertEquals(12, obj.sumRegion(1, 2, 2, 4));
    }
}
