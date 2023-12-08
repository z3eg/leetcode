package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class _283 {
    public void moveZeroes(int[] nums) {

    }

    @Test
    public void test() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        assertArrayEquals(new int[]{1,3,12,0,0}, nums);
        nums = new int[]{0};
        moveZeroes(nums);
        assertArrayEquals(new int[]{0}, nums);
    }
}
