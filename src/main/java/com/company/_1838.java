package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _1838 {
    public int maxFrequency(int[] nums, int k) {

    }

    @Test
    public void test() {
        assertEquals(3, maxFrequency(new int[]{1,2,4}, 5));
        assertEquals(2, maxFrequency(new int[]{1,4,8,13}, 5));
        assertEquals(1, maxFrequency(new int[]{3,9,6}, 2));
    }
}
