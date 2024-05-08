package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _661 {

    /*4
    ms
            Beats
93.84%
    of users with Java*/
    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = smooth(i,j,img);
            }
        }
        return res;
    }

    private int smooth(int i, int j, int[][] img) {
        int sum = 0;
        int amount = 0;
        for (int k = i-1; k <= i+1; k++) {
            if (k<0 || k >= img.length)
                continue;
            for (int l = j-1; l <= j+1; l++) {
                if (l >= 0 && l < img[k].length) {
                    sum += img[k][l];
                    amount++;
                }
            }
        }
        return sum/amount;
    }

    @Test
    public void test() {
        assertEquals(new int[][]{{0,0,0},{0,0,0},{0,0,0}}, imageSmoother(new int[][]{{1,1,1},{1,0,1},{1,1,1}}));
//        assertEquals(new int[][]{}, imageSmoother(new int[][]{}));
    }
}
