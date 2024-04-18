package com.company;

public class _463 {

    /*4
    ms
    Beats
    99.58%
    of users with Java*/
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==1) {
                    if (i==0)
                        res++;
                    if (i ==grid.length-1)
                        res++;
                    if (i>0 && grid[i-1][j]==0)
                        res++;
                    if (i< grid.length-1 && grid[i+1][j]==0)
                        res++;

                    if (j==0)
                        res++;
                    if ( j ==grid[i].length-1)
                        res++;
                    if (j>0 && grid[i][j-1]==0)
                        res++;
                    if (j< grid[i].length-1 && grid[i][j+1]==0)
                        res++;
                }
            }
        }
        return res;
    }

}
