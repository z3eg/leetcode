package com.company;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix-ii/
public class _59_SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int top = 0, left = 0;
        int bottom = matrix.length-1;
        int right = matrix[0].length-1;
        String curDir = "right";
        while (count <= n*n) {
            switch (curDir) {
                case "right" -> {
                    for (int i = left; i <= right; i++) {
                        matrix[top][i] = count;
                        count++;
                    }
                    top++;
                }
                case "left" -> {
                    for (int i = right; i >= left; i--) {
                        matrix[bottom][i] = count;
                        count++;
                    }
                    bottom--;
                }
                case "up" -> {
                    for (int i = bottom; i >= top; i--) {
                        matrix[i][left] = count;
                        count++;
                    }
                    left++;
                }
                case "down" -> {
                    for (int i = top; i <= bottom; i++) {
                        matrix[i][right] = count;
                        count++;
                    }
                    right--;
                }
            }
            curDir = newDir(curDir);
        }
        return matrix;
    }

    private String newDir(String curDir) {
        return switch (curDir) {
            case "right" -> "down";
            case "down" -> "left";
            case "left" -> "up";
            case "up" -> "right";
            default -> ";";
        };
    }
}
