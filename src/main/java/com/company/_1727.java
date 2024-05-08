package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _1727 {

    /*Wrong Answer
    16 / 58 testcases passed*/
    /*public int largestSubmatrix(int[][] matrix) {
        int[][] onesBefore = new int[matrix.length][matrix[0].length];
        int[] minNonZeroes = new int[matrix.length];
        Arrays.fill(minNonZeroes, Integer.MAX_VALUE);
        minNonZeroes[0] = 0;
        int[] countNonZeroes = new int[matrix.length];
//        onesBefore[0] = Arrays.copyOf(matrix[0],matrix[0].length);
        for (int i = 0; i < matrix[0].length; i++) {
            onesBefore[0][i] = matrix[0][i];
            minNonZeroes[0] = Math.max(onesBefore[0][i], minNonZeroes[0]);
            countNonZeroes[0]+=matrix[0][i];
        }
        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = 1; r < matrix.length; r++) {
                countNonZeroes[r] +=matrix[r][c];
                onesBefore[r][c] = matrix[r-1][c]==0?matrix[r][c]:(matrix[r][c]==0?0:onesBefore[r-1][c]+1);
                if (onesBefore[r][c]!=0)
                    minNonZeroes[r] = Math.min(minNonZeroes[r],onesBefore[r][c]);
            }
        }
        int res = 0;
        for (int i = 0; i < minNonZeroes.length; i++) {
            if (minNonZeroes[i] == Integer.MAX_VALUE)
                minNonZeroes[i] = 0;
        }
        for (int i = 0; i < minNonZeroes.length; i++) {
            res = Math.max(res, minNonZeroes[i]*countNonZeroes[i]);
        }
        return res;
    }*/

    //NOPE, THIS IS ALSO SHIT
    /*public int largestSubmatrix(int[][] matrix) {
        int[][] onesBefore = new int[matrix.length][matrix[0].length];
        int[][] countOfNs = new int[matrix.length][matrix.length+1]; //each cell represents how many columns that have (col_idx) 1s before them are in this row
        for (int i = 0; i < matrix[0].length; i++) {
            onesBefore[0][i] = matrix[0][i];
            countOfNs[0][onesBefore[0][i]]++;
        }
        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = 1; r < matrix.length; r++) {
                onesBefore[r][c] = matrix[r-1][c]==0?matrix[r][c]:(matrix[r][c]==0?0:onesBefore[r-1][c]+1);
                countOfNs[r][onesBefore[r][c]]++;
            }
        }
        int res = 0;
        for (int i = 0; i < countOfNs.length; i++) {
            for (int j = 0; j < countOfNs[i].length; j++) {
                res = Math.max(res, countOfNs[i][j]*j);
            }
        }
        return res;
    }*/


    /*13
    ms
            Beats
63.86%
    of users with Java*/
    public int largestSubmatrix(int[][] matrix) {
        int[][] onesBefore = new int[matrix.length][matrix[0].length];
        System.arraycopy(matrix[0], 0, onesBefore[0], 0, matrix[0].length);
        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = 1; r < matrix.length; r++) {
                onesBefore[r][c] = matrix[r-1][c]==0?matrix[r][c]:(matrix[r][c]==0?0:onesBefore[r-1][c]+1);
            }
        }
        int res = 0;
        for (int i = 0; i < onesBefore.length; i++) {
            Arrays.sort(onesBefore[i]);
            for(int j=1; j<=onesBefore[0].length; j++){
                res = Math.max(res, j*onesBefore[i][onesBefore[0].length-j]); //i have literally no idea why we do this tbh
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(4, largestSubmatrix(new int[][]{{0,0,1},{1,1,1},{1,0,1}}));
        assertEquals(34, largestSubmatrix(new int[][]{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1},
                {0,1,1,0,1,1,1,1,0,1,1,0,0,1,0,1,1,1,1,0,1,1,1,1,1,1}})); //TC #16
        assertEquals(0, largestSubmatrix(new int[][]{{0}}));
        assertEquals(1, largestSubmatrix(new int[][]{{1}}));
        assertEquals(2, largestSubmatrix(new int[][]{{0,0},{1,1}}));
        assertEquals(2, largestSubmatrix(new int[][]{{0,1},{0,1}}));
        assertEquals(1, largestSubmatrix(new int[][]{{0,0},{0,1}}));
        assertEquals(2, largestSubmatrix(new int[][]{{1,1},{0,1}}));
        assertEquals(4, largestSubmatrix(new int[][]{{1,1},{1,1}}));
        assertEquals(4, largestSubmatrix(new int[][]{{0,0,1},{1,1,1},{1,0,1}}));
        assertEquals(3, largestSubmatrix(new int[][]{{1,0,1,0,1}}));
        assertEquals(2, largestSubmatrix(new int[][]{{1,1,0},{1,0,1}}));
    }
}
