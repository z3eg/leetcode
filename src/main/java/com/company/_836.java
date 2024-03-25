package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return true;
    }

    @Test
    public void test() {
        assertTrue(isRectangleOverlap(new int[]{0,0,2,2}, new int[]{1,1,3,3}));
        assertFalse(isRectangleOverlap(new int[]{0,0,1,1}, new int[]{1,0,2,1}));
        assertFalse(isRectangleOverlap(new int[]{0,0,1,1}, new int[]{2,2,3,3}));
    }
}
