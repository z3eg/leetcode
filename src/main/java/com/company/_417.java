package com.company;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class _417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        //length, vertical
        int l = heights.length;
        //width, horizontal
        int w = heights[0].length;
        int [][] canPac = new int[l][w];
        int [][] canAtl = new int[l][w];
        int [][] canBoth = new int[l][w];
        for (int i = 0; i < l; i++) {
            canPac[i][0] = 1;    //init west shore
            canAtl[i][w-1] = 1;  //init east shore
        }
        for (int i = 0; i < w; i++) {
            canPac[0][i] = 1;    //init north shore
            canAtl[l-1][i] = 1;  //init south shore
        }
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < w; j++) {
                if (canBoth(heights,l,w,i,j,canBoth,canPac,canAtl)==1) {
                    LinkedList<Integer> cur = new LinkedList<>();
                    cur.add(i);
                    cur.add(j);
                    res.add(cur);
                }
            }
        }
        return res;
    }

    int canBoth(int[][] heights, int l, int w, int r, int c, int[][]canBoth, int[][]canPac, int[][]canAtl) {
        if (canBoth[r][c]!=0)
            return canBoth[r][c];
        if (can(heights,l,w,r,c,canPac)==1 && can(heights,l,w,r,c,canAtl)==1) {
            canBoth[r][c] = 1;
            return 1;
        }
        canBoth[r][c] = -1;
        return -1;
    }

     int can(int[][] heights, int l, int w, int r, int c, int[][] canReach) {
        if (r<0 || c<0)
            return 1;
        if (r>=l || c >=w)
            return -1;
        if (canReach[r][c]!=0)
            return canReach[r][c];
        int curHeight = heights[r][c];
        if (((can(heights, l,w,r+1,c,canReach)==1) && (curHeight >= getHeight(heights,l,w,r+1,c))) ||
            ((can(heights, l,w,r-1,c,canReach)==1) && (curHeight >= getHeight(heights,l,w,r-1,c))) ||
            ((can(heights, l,w,r,c+1,canReach)==1) && (curHeight >= getHeight(heights,l,w,r,c+1))) ||
            ((can(heights, l,w,r,c-1,canReach)==1) && (curHeight >= getHeight(heights,l,w,r,c-1))))
        {
            canReach[r][c] = 1;
            return 1;
        }
        canReach[r][c] = -1;
        return -1;
     }

     int getHeight(int[][] heights, int l, int w, int r, int c) {
        if (r<0 || c < 0 || r > l || c > w)
            return 0;
        return heights[r][c];
     }

     @Test
     public void test() {
         System.out.println(pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));
     }


}
