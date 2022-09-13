package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/matrix-diagonal-sum/
public class _1572_MatrixDiagonalSum {

    public int diagonalSum(int[][] mat) {
        int height = mat.length;
        int width = mat[0].length;
        int sum = 0;
        for (int i = 0; i < height; i++) {
            sum+=mat[i][i];
            sum+=mat[i][width-1-i];
        }
        return sum-(width%2==0?0:mat[width/2][width/2]);
    }


    @Test
    public void test() {
        assertEquals(25, diagonalSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }

    /*Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25*/
}
