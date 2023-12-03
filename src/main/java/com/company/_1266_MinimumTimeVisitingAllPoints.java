package com.company;

//https://leetcode.com/problems/minimum-time-visiting-all-points/
public class _1266_MinimumTimeVisitingAllPoints {

    /*1
    ms
            Beats
95.62%
    of users with Java*/
    public int minTimeToVisitAllPoints(int[][] points) {
        int secs = 0;
        int i1 = points.length - 1;
        for (int i = 0; i < i1; i++) {
            secs+=Math.max(Math.abs(points[i][0]-points[i+1][0]),Math.abs(points[i][1]-points[i+1][1]));
        }
        return secs;
    }

    /*public int minTimeToVisitAllPoints(int[][] points) {
        int secs = 0;
        for (int i = 0; i < points.length-1; i++) {
            while (points[i][0]!=points[i+1][0] || points[i][1]!=points[i+1][1]) {
                if (points[i][0]!=points[i+1][0])
                    points[i][0]+=(points[i][0]<points[i+1][0])?1:-1;
                if (points[i][1]!=points[i+1][1])
                    points[i][1]+=(points[i][1]<points[i+1][1])?1:-1;
                secs++;
            }
        }
        return secs;
    }*/


}
