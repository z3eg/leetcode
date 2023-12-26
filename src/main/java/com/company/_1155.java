package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1155 {
    public int numRollsToTarget(int n, int k, int target) {
        return 0;
    }
    @Test
    public void test() {
        assertEquals(1, numRollsToTarget(1,6,3));
        assertEquals(6, numRollsToTarget(2,6,7));
        assertEquals(222616187, numRollsToTarget(30,30,500));
    }
}
