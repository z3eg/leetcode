package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

//https://leetcode.com/problems/search-a-2d-matrix/
public class _74_SearchA2DMatrix {

    /*-ms
    Beats 100.00%of users with Java*/

    public boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0])
            return false;
        int[] row = getRow(matrix, 0, matrix.length, target);
        if (row == null)
            return false;
        return existsInTheRow(row, 0, row.length, target);
    }

    int[] getRow(int[][] matrix, int l, int r, int target) {
        if (r-l<2)
            return matrix[l];
        if (target < matrix[l][0])
            return matrix[l-1];
        int mid = (r + l)/2;
        if (target < matrix[mid][0])
            return getRow(matrix, l, mid, target);
        else
            return getRow(matrix, mid, r, target);
    }

    boolean existsInTheRow(int[] row, int l, int r, int target) {
        if (target==row[l])
            return true;
        if (r-l<2)
            return false;
        int mid = (l+r)/2;
        if (target==row[mid])
            return true;
        if (target < row[mid])
            return existsInTheRow(row, l, mid, target);
        else
            return existsInTheRow(row, mid, r, target);
    }


    @Test
    public void test() {
        assertTrue(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        assertFalse(searchMatrix(new int[][]{{1,3,5,7,9},{10,11,16,20,21}}, 13));
        assertFalse(searchMatrix(new int[][]{{1,3,5,7,9},{10,11,16,20,21},{23,30,34,60,65}}, 13));
        assertFalse(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
        assertFalse(searchMatrix(new int[][]{{1}}, 13));
        assertTrue(searchMatrix(new int[][]{{1}}, 1));
        assertTrue(searchMatrix(new int[][]{{1,2}}, 1));
        assertTrue(searchMatrix(new int[][]{{1},{2}}, 1));
        assertTrue(searchMatrix(new int[][]{{1},{2}}, 2));
        assertFalse(searchMatrix(new int[][]{{1},{2}}, 3));
        assertFalse(searchMatrix(new int[][]{{1},{2}}, 0));
        assertFalse(searchMatrix(new int[][]{{1},{2}}, -3));
        assertFalse(searchMatrix(new int[][]{{1},{5}}, 3));
        assertTrue(searchMatrix(new int[][]{{1,2}}, 2));
        assertTrue(searchMatrix(new int[][]{{1,2},{3,5}}, 3));
        assertFalse(searchMatrix(new int[][]{{1,2},{3,5}}, 4));
        assertFalse(searchMatrix(new int[][]{{1,2},{3,5},{7,8}}, 4));
        assertTrue(searchMatrix(new int[][]{{1,2},{3,5},{7,8}}, 8));
        assertTrue(searchMatrix(new int[][]{{1,2},{3,5},{7,8}}, 1));
        assertTrue(searchMatrix(new int[][]{{1,2},{3,5},{7,8}}, 3));
        assertTrue(searchMatrix(new int[][]{{1,2},{3,5},{7,8}}, 5));
        assertTrue(searchMatrix(new int[][]{{1,2,5},{7,8,9}},9));
        assertTrue(searchMatrix(new int[][]{{1,2,5},{7,8,9}},5));
        assertTrue(searchMatrix(new int[][]{{1,2,5},{7,8,9}},1));
        assertTrue(searchMatrix(new int[][]{{1,2,5},{7,8,9}},7));
        assertTrue(searchMatrix(new int[][]{{1,2,5},{7,8,9}},5));
        assertFalse(searchMatrix(new int[][]{{1,2,5},{7,8,9}},6));
    }

}
