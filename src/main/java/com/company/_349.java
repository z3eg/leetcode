package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class _349 {

    public int[] intersection(int[] nums1, int[] nums2) {

    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{2}, intersection(new int[]{1,2,2,1}, new int[]{2,2}));
        assertArrayEquals(new int[]{9,4}, intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4}));
    }
}
