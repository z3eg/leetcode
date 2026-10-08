package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _11 {

    /*TLE 59 / 65 testcases passed*/
    public int maxArea(int[] height) {
        int hLen = height.length;
        int maxWater = 0;
        for (int i = 0; i < hLen - 1; i++) {
            for (int j = i+1; j < hLen; j++) {
                maxWater = Math.max(maxWater,((j-i)*Math.min(height[i],height[j])));
            }
        }
        return maxWater;
    }

    @Test
    public void test() {
        assertEquals(49, maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        assertEquals(1, maxArea(new int[]{1,1}));
    }
}
