package com.company;

public class _812 {

    /*5
    ms
            Beats
88.92%
    of users with Java*/

    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                for (int k = j+1; k < points.length; k++) {
                    max = Math.max(max, area(points[i],points[j],points[k]));
                }
            }
        }
        return max;
    }

    private double area(int[] p1, int[] p2, int[] p3) {
//        Area = (1/2) * |x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)|
        return 0.5*Math.abs(p1[0]*(p2[1]-p3[1]) + p2[0]*(p3[1]-p1[1]) + p3[0]*(p1[1]-p2[1]));
    }
}
