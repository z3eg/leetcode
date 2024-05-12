package com.company;

//https://leetcode.com/problems/largest-local-values-in-a-matrix/
public class _2373_LargestLocalValuesInAMatrix {

    /*2
    ms
    Beats
    100.00%
    of users with Java*/
    public int[][] largestLocal(int[][] grid) {
        int resHeight = grid.length - 2;
        int resWidth = grid[0].length - 2;
        int[][] res = new int[resHeight][resWidth];
        for (int i = 0; i < resHeight; i++) {
            for (int j = 0; j < resWidth; j++) {
                int max = 0;
                for (int k = i; k <= i+2; k++) {
                    for (int l = j; l <= j+2; l++) {
                        max = Math.max(max,grid[k][l]);
                    }
                }
                res[i][j] = max;
            }
        }
        return res;
    }
}
