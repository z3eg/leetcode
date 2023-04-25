package com.company;

//https://leetcode.com/problems/sort-the-students-by-their-kth-score/
public class _2545_SortTheStudentsByTheirKthScore {
    public int[][] sortTheStudents(int[][] score, int k) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            int scoreLen = score.length - 1;
            for (int i = 0; i < scoreLen; i++) {
                if (score[i][k] < score[i+1][k]) {
                    int[] tempRow = score[i];
                    score[i] = score[i+1];
                    score[i+1] = tempRow;
                    sorted = false;
                }
            }
        }
        return score;
    }
}
