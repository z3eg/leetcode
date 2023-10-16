package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*119. Pascal's Triangle II
        https://leetcode.com/problems/pascals-triangle-ii/description/?envType=daily-question&envId=2023-10-16*/
public class _119 {
    /*1ms
    Beats 79.70%of users with Java*/
    public List<Integer> getRow(int rowIndex) {
        int[][] pt = new int[rowIndex+1][rowIndex+1];
        for (int i = 0; i < pt.length; i++) {
            pt[i][0] = 1;
            pt[i][i] = 1;
        }
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 1; j < i; j++) {
                pt[i][j] = pt[i-1][j-1]+pt[i-1][j];
            }
        }
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(pt[rowIndex][i]);
        }
        return res;
    }
}
