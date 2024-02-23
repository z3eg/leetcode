package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return 0;
    }

    @Test
    public void test() {
        assertEquals(700, findCheapestPrice(4, new int[][]{{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}}, 0,3,1));
        assertEquals(200, findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0,2,1));
        assertEquals(500, findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0,2,0));
    }
}
