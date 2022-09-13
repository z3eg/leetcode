package com.company;

//https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
public class _1252_CellsWithOddValuesInAMatrix {

    public int oddCells(int m, int n, int[][] indices) {
        int[][] res = new int[m][n];
        int len = indices.length;
        for (int[] index : indices) {
            int r = index[0];
            int c = index[1];
            for (int i = 0; i < m; i++) {
                res[i][c]++;
            }
            for (int i = 0; i < n; i++) {
                res[r][i]++;
            }
        }
        int oddNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (res[i][j]%2==1)
                    oddNum++;
            }
        }
        return oddNum;
    }
}
