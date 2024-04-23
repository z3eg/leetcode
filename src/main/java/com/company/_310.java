package com.company;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        return null;
    }

    @Test
    public void test() {
        assertEquals(Arrays.asList(1), findMinHeightTrees(4, new int[][]{{1,0},{1,2},{1,3}}));
        assertEquals(Arrays.asList(3,4), findMinHeightTrees(4, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}}));
    }
}
