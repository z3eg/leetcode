package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _485 {
    public int findMaxConsecutiveOnes(int[] nums) {

    }

    @Test
    public void test() {
        assertEquals(3, findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
        assertEquals(2, findMaxConsecutiveOnes(new int[]{1,0,1,1,0,1}));
    }
}
