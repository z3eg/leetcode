package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _42 {

    /*Wrong Answer
21 / 322 testcases passed*/
    public int trap(int[] height) {
        return 0;
    }

    @Test
    public void test() {
        assertEquals(6, trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        assertEquals(9, trap(new int[]{4,2,0,3,2,5}));
    }
}
