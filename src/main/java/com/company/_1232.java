package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*1232. Check If It Is a Straight Line
        https://leetcode.com/problems/check-if-it-is-a-straight-line/*/
public class _1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int firstXDiff = coordinates[1][0]-coordinates[0][0];
        if (firstXDiff == 0) {
            for (int i = 1; i < coordinates.length-1; i++) {
                if (coordinates[i][0]!=coordinates[i+1][0])
                    return false;
            }
            return true;
        }
        int firstYDiff = coordinates[1][1]-coordinates[0][1];
        if (firstYDiff == 0) {
            for (int i = 1; i < coordinates.length-1; i++) {
                if (coordinates[i][1]!=coordinates[i+1][1])
                    return false;
            }
            return true;
        }
        for (int i = 1; i < coordinates.length-1; i++) {
            int xDiff1 = coordinates[i + 1][0] - coordinates[i][0];
            int yDiff1 = coordinates[i + 1][1] - coordinates[i][1];
            int xDiff2 = coordinates[i][0] - coordinates[i - 1][0];
            int yDiff2 = coordinates[i][1] - coordinates[i - 1][1];
            if (xDiff1==0 || xDiff2==0 || yDiff1==0 || yDiff2==0)
                return false;
            if (!sameSign(xDiff1,xDiff2) && sameSign(yDiff1,yDiff2))
                return false;
            if (!sameSign(yDiff1, yDiff2) && sameSign(xDiff1,xDiff2))
                return false;
            if (xDiff1 / yDiff1 != xDiff2 / yDiff2)
                return false;
        }
        return true;
    }

    private boolean sameSign(int a, int b) {
        return ((a>0 && b>0) || (a<0 && b<0));
    }

    @Test
    public void test() {
        assertTrue(checkStraightLine(new int[][]{{2,4},{2,5},{2,8}}));
        assertTrue(checkStraightLine(new int[][]{{0,0},{0,1},{0,-1}}));
        assertFalse(checkStraightLine(new int[][]{{1,-8},{2,-3},{1,2}}));
        assertFalse(checkStraightLine(new int[][]{{1,1},{2,2},{2,0}}));
        assertTrue(checkStraightLine(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}));
        assertFalse(checkStraightLine(new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}));
    }
}
