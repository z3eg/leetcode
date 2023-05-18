package com.company;

/*https://leetcode.com/problems/matrix-diagonal-sum/
1572. Matrix Diagonal Sum*/
public class _1572 {
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
}
