package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*2643. Row With Maximum Ones
        https://leetcode.com/problems/row-with-maximum-ones/*/
public class _2643 {

    /*Runtime
    5 ms
    Beats
    84.89%*/
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] res = new int[2];
        int width = mat[0].length;
        int matLen = mat.length;
        for (int i = 0; i < matLen; i++) {
            int curOnes = 0;
            for (int j = 0; j < width; j++) {
                if (mat[i][j]==1)
                    curOnes++;
            }
            if (curOnes > res[1]) {
                res[0] = i;
                res[1] = curOnes;
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{0,1},rowAndMaximumOnes(new int[][]{{1,0},{1,0}}));
        assertArrayEquals(new int[]{1,2},rowAndMaximumOnes(new int[][]{{0,0,0},{0,1,1}}));
        assertArrayEquals(new int[]{1,2},rowAndMaximumOnes(new int[][]{{0,0},{1,1},{0,0}}));
    }
}
