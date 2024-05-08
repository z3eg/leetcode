package com.company;

import java.util.Arrays;

/*https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
1637. Widest Vertical Area Between Two Points Containing No Points*/
public class _1637 {

    /*13
    ms
            Beats
    98.07%
    of users with Java*/
    public int maxWidthOfVerticalArea(int[][] points) {
        int pointsLen = points.length;
        int[] xs = new int[pointsLen];
        for (int i = 0; i < pointsLen; i++) {
            xs[i] = points[i][0];
        }
        Arrays.sort(xs);
        int max = 0;
        int xsLen = xs.length;
        for (int i = 1; i < xsLen; i++) {
            max = Math.max(max, xs[i]-xs[i-1]);
        }
        return max;
    }
}
