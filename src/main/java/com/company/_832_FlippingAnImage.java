package com.company;

//https://leetcode.com/problems/flipping-an-image/
public class _832_FlippingAnImage {

    public int[][] flipAndInvertImage(int[][] image) {
        int height = image.length;
        int width = image[0].length;
        int[][] res = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                res[i][j] = (image[i][width-j-1]==1)?0:1;
            }
        }
        return res;
    }
}
