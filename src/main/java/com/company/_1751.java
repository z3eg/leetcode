package com.company;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*1751. Maximum Number of Events That Can Be Attended II
https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/*/
public class _1751 {

    public int maxValue(int[][] events, int k) {
        HashMap<Integer, List<Integer>> nonOverLappingMap = new HashMap<>();
        return 0;
    }

    @Test
    public void test() {
        assertEquals(7, maxValue(new int[][]{{1,2,4},{3,4,3},{2,3,1}},2));
        assertEquals(10, maxValue(new int[][]{{1,2,4},{3,4,3},{2,3,10}},2));
        assertEquals(9, maxValue(new int[][]{{1,1,1},{2,2,2},{3,3,3},{4,4,4}},3));
    }
}
