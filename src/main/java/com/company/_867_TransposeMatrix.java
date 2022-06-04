package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

//https://leetcode.com/problems/transpose-matrix/
public class _867_TransposeMatrix {

    public int[][] transpose(int[][] matrix) {
        int [][] res = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = matrix[j][i];
            }
        }
        return res;
    }

    /*Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]*/

    @Test
    public void test() {
        assertArrayEquals(new int[][]{{1,4,7},{2,5,8},{3,6,9}}, transpose(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        assertArrayEquals(new int[][]{{1,4},{2,5},{3,6}}, transpose(new int[][]{{1,2,3},{4,5,6}}));
    }

}
