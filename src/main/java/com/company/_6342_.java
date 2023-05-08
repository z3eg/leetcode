package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

// First Completely Painted Row or Column
//https://leetcode.com/contest/weekly-contest-343/problems/first-completely-painted-row-or-column/
public class _6342_ {

    //still TLE :(
    /*public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rowNum = mat.length;
        int colNum = mat[0].length;

        int[] rowMatches = new int[rowNum];
        int[] colMatches = new int[colNum];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < rowNum; j++) {
                for (int k = 0; k < colNum; k++) {
                    if (arr[i] == mat[j][k]) {
                        rowMatches[j]++;
                        if (rowMatches[j]==colNum)
                            return i;
                        colMatches[k]++;
                        if (colMatches[k]==rowNum)
                            return i;
                    }
                }
            }
        }
        return 0;
    }*/

    @Test
    public void test() {
        assertEquals(2  , firstCompleteIndex(new int[]{2,4,1,3,5,6}, new int[][]{{3,2},{1,4},{5,6}}));
        assertEquals(1, firstCompleteIndex(new int[]{2,4,1,3,5,6}, new int[][]{{3,2,5},{1,4,6}}));
        assertEquals(2, firstCompleteIndex(new int[]{1,3,4,2}, new int[][]{{1,4},{2,3}}));
        assertEquals(3, firstCompleteIndex(new int[]{2,8,7,4,1,3,5,6,9}, new int[][]{{3,2,5},{1,4,6},{8,7,9}}));
    }

    //TLE
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rowNum = mat.length;
        int colNum = mat[0].length;

        List<Integer>[] rows = new LinkedList[rowNum];
        List<Integer>[] cols = new LinkedList[colNum];
        for (int i = 0; i <colNum ; i++) {
            cols[i] = new LinkedList<>();
        }

        for (int i = 0; i < rowNum; i++) {
            rows[i] = new LinkedList<>();
            for (int j = 0; j < colNum; j++) {
                rows[i].add(mat[i][j]);
                cols[j].add(mat[i][j]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < rowNum; j++) {
                rows[j].remove(Integer.valueOf(arr[i]));
                if (rows[j].isEmpty())
                    return i;
            }
            for (int j = 0; j < colNum; j++) {
                cols[j].remove(Integer.valueOf(arr[i]));
                if (cols[j].isEmpty())
                    return i;
            }
        }
        return 0;
    }
}
