package com.company;

import java.util.LinkedList;

//https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/
public class _1828_QueriesOnNumberOfPointsInsideACircle {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int[] point : points) {
                if (pointBelongsToQuery(point, queries[i]))
                    res[i]++;
            }
        }
        return res;
    }

    private boolean pointBelongsToQuery(int[] point, int[] query) {
        int width = Math.abs(point[0] - query[0]);
        int height = Math.abs(point[1] - query[1]);
        double dist = Math.sqrt(width*width + height*height);
        return dist<=query[2];
    }
}
