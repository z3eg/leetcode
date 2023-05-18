package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/
public class _54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int top = 0, left = 0;
        int bottom = matrix.length-1;
        int right = matrix[0].length-1;
        String curDir = "right";
        while (res.size() < matrix.length*matrix[0].length) {
            switch (curDir) {
                case "right" -> {
                    for (int i = left; i <= right; i++) {
                        res.add(matrix[top][i]);
                    }
                    top++;
                }
                case "left" -> {
                    for (int i = right; i >= left; i--) {
                        res.add(matrix[bottom][i]);
                    }
                    bottom--;
                }
                case "up" -> {
                    for (int i = bottom; i >= top; i--) {
                        res.add(matrix[i][left]);
                    }
                    left++;
                }
                case "down" -> {
                    for (int i = top; i <= bottom; i++) {
                        res.add(matrix[i][right]);
                    }
                    right--;
                }
            }
            curDir = newDir(curDir);
        }
        return res;
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

    @Test
    public void test() {
        spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
