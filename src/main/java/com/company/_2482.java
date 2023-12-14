package com.company;

public class _2482 {
    /*11
    ms
            Beats
55.02%
    of users with Java*/
    public int[][] onesMinusZeros(int[][] grid) {
        int[] oneRows = new int[grid.length];
        int[] zeroRows = new int[grid.length];
        int[] oneCols = new int[grid[0].length];
        int[] zeroCols = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1) {
                    oneRows[i]++;
                    oneCols[j]++;
                }
                else {
                    zeroRows[i]++;
                    zeroCols[j]++;
                }
            }
        }
        int[][] res = new int[grid.length][grid[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = oneRows[i]+oneCols[j]-zeroRows[i]-zeroCols[j];
            }
        }
        return res;
    }
}
