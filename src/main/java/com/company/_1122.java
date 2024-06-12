package com.company;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class _1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        return new int[]{};
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{2,2,2,1,4,3,3,9,6,7,19}, relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6}));
        assertArrayEquals(new int[]{22,28,8,6,17,44}, relativeSortArray(new int[]{28,6,22,8,44,17}, new int[]{22,28,8,6}));
    }
}
