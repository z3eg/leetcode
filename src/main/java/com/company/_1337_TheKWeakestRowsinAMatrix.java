package com.company;

import java.util.Arrays;

//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
public class _1337_TheKWeakestRowsinAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] indexes = new int[mat.length];
        int[] weaknesses = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    weaknesses[i]++;
                }
            }
            indexes[i] = i;
        }
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < weaknesses.length-1; i++) {
                if (weaknesses[i]<weaknesses[i+1]) {
                    isSorted = false;
                    int tmp = weaknesses[i];
                    weaknesses[i] = weaknesses[i+1];
                    weaknesses[i+1] = tmp;
                    tmp = indexes[i];
                    indexes[i] = indexes[i+1];
                    indexes[i+1] = tmp;
                }
            }
        }
        return Arrays.copyOfRange(indexes,0,k);
    }
}
