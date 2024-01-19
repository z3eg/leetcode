package com.company;

import java.util.Arrays;

public class _931 {

    /*7
    ms
            Beats
54.05%
    of users with Java*/
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] fp = new int[n][n];
        fp[0] = Arrays.copyOf(matrix[0], n);
        int min;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j==0)
                    min = Math.min(fp[i-1][j],fp[i-1][j+1]);
                else if (j== n -1)
                    min = Math.min(fp[i-1][j],fp[i-1][j-1]);
                else {
                    min = Math.min(fp[i-1][j],fp[i-1][j+1]);
                    min = Math.min(min,fp[i-1][j-1]);
                }
                fp[i][j] = matrix[i][j]+min;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, fp[n -1][i]);
        }
        return res;
    }
    
}
