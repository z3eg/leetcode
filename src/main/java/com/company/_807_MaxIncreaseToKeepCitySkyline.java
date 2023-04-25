package com.company;

//https://leetcode.com/problems/max-increase-to-keep-city-skyline/
public class _807_MaxIncreaseToKeepCitySkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] maxInRow = new int[n];
        int[] maxInCol = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxInCol[i] = Math.max(maxInCol[i],grid[i][j]);
                maxInRow[j] = Math.max(maxInRow[j],grid[i][j]);
            }
        }
        int maxInc = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxInc+=Math.min((maxInRow[j]-grid[i][j]),(maxInCol[i]-grid[i][j]));
            }
        }
        return maxInc;
    }
}
