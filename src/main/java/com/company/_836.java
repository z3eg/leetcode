package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _836 {

    /*Wrong Answer
28 / 40 testcases passed*/
    /*public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return inBetween(rec1[0], rec1[1], rec2[0], rec2[1], rec2[2], rec2[3]) ||
                inBetween(rec1[2], rec1[3], rec2[0], rec2[1], rec2[2], rec2[3]);
    }

    boolean inBetween(int x, int y, int x1, int y1, int x2, int y2) {
        return x > x1 && y > y1 && x < x2 && y < y2;
    }*/

    /*Wrong Answer
36 / 40 testcases passed*/
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1DotInRec2(rec1, rec2)
                || rec1DotInRec2(rec2, rec1);
    }

    private boolean rec1DotInRec2(int[] rec1, int[] rec2) {
        return inBetween(rec1[0], rec1[1], rec2[0], rec2[1], rec2[2], rec2[3]) ||
                inBetween(rec1[0], rec1[3], rec2[0], rec2[1], rec2[2], rec2[3]) ||
                inBetween(rec1[2], rec1[1], rec2[0], rec2[1], rec2[2], rec2[3]) ||
                inBetween(rec1[2], rec1[3], rec2[0], rec2[1], rec2[2], rec2[3]);

    }

    boolean inBetween(int x, int y, int x1, int y1, int x2, int y2) {
        return x >= x1 && y > y1 && x <= x2 && y < y2
                || x > x1 && y >= y1 && x < x2 && y <= y2;
    }

    @Test
    public void test() {
        assertTrue(isRectangleOverlap(new int[]{7,8,13,15}, new int[]{10,8,12,20}));
        assertTrue(isRectangleOverlap(new int[]{0,0,2,2}, new int[]{1,1,3,3}));
        assertFalse(isRectangleOverlap(new int[]{0,0,1,1}, new int[]{1,0,2,1}));
        assertFalse(isRectangleOverlap(new int[]{0,0,1,1}, new int[]{2,2,3,3}));
    }
}
