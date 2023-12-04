package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class _219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

    }

    @Test
    public void test() {
        assertTrue(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        assertTrue(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        assertFalse(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }
}
