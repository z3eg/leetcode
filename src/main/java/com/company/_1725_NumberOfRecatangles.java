package com.company;

import java.util.Arrays;

public class _1725_NumberOfRecatangles {
    /*public int countGoodRectangles(int[][] rectangles) {
        int recLen = rectangles.length;
        int larPos = 0;
        for (int i = 0; i < recLen; i++) {
            larPos = Math.max(larPos, Math.min(rectangles[i][0], rectangles[i][1]));
        }
        int counter = 0;
        for (int i = 0; i < recLen; i++) {
            if (rectangles[i][0]>=larPos && rectangles[i][1]>=larPos)
                counter++;
        }
        return counter;
    }*/
    public int countGoodRectangles(int[][] rectangles) {
        int recLen = rectangles.length;
        int larPos = 0;
        int counter = 0;
        for (int i = 0; i < recLen; i++) {
            int curLarPos = Math.min(rectangles[i][0], rectangles[i][1]);
            if (curLarPos<=larPos) {
                larPos = curLarPos;
                counter=0;
            }
            counter++;
        }
        return counter;
    }
}
