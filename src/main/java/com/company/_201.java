package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _201 {
    public int rangeBitwiseAnd(int left, int right) {
        for (int i = left+1; i <= right ; i++) {
            left=left&i;
        }
        return left;
    }

    @Test
    public void test() {
        assertEquals(4, rangeBitwiseAnd(5,7));
        assertEquals(0, rangeBitwiseAnd(0,0));
//        assertEquals(0, rangeBitwiseAnd(1,2147483647));
    }
}
