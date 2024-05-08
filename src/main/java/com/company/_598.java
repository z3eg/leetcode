package com.company;

public class _598 {


//    Memory Limit Exceeded
//6 / 69 testcases passed
    public int maxCount(int m, int n, int[][] ops) {
        int[][] mat = new int[m][n];
        int max = 0;
        for (int[] op : ops) {
            for (int i = 0; i < op[0]; i++) {
                for (int j = 0; j < op[1]; j++) {
                    mat[i][j]++;
                    max = Math.max(max, mat[i][j]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j]==max)
                    res++;
            }
        }
        return res;
    }
}
