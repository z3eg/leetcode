package com.company;

public class _733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] changed = new boolean[image.length][image[0].length];
        fill(sr, sc, image, image[sr][sc], color, changed);
        return image;
    }

    void fill(int r, int c, int[][] image, int oldColor, int newColor, boolean[][] changed) {
        if (r < 0 || r >= image.length)
            return;
        if (c < 0 || c >= image[0].length)
            return;
        if (changed[r][c])
            return;
        if (image[r][c] == oldColor) {
            image[r][c] = newColor;
            changed[r][c] = true;
            fill (r-1, c, image, oldColor, newColor, changed);
            fill (r+1, c, image, oldColor, newColor, changed);
            fill (r, c-1, image, oldColor, newColor, changed);
            fill (r, c+1, image, oldColor, newColor, changed);
        }
    }
}
