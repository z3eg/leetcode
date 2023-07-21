package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://leetcode.com/problems/height-checker/
public class _1051_HeightChecker {
    /*1ms
    Beats 91.22%of users with Java*/
    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (expected[i] != heights[i])
                res++;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(3, heightChecker(new int[]{1,1,4,2,1,3}));
        assertEquals(5, heightChecker(new int[]{5,1,2,3,4}));
        assertEquals(0, heightChecker(new int[]{1,2,3,4,5}));
    }
}
