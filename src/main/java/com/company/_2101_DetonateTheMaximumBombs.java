package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/detonate-the-maximum-bombs/
public class _2101_DetonateTheMaximumBombs {
    public int maximumDetonation(int[][] bombs) {
        int res = 0;
        for (int i = 0; i < bombs.length; i++) {
            res = Math.max(res, detonate(i, 0, bombs, new boolean[bombs.length]));
        }
        return res;
    }

    private int detonate(int index, int sum, int[][] bombs, boolean[] detonated) {
        sum++;
        detonated[index] = true;
        for (int i = 0; i < bombs.length; i++) {
            if (i!=index && canDetonate(bombs[index], bombs[i]) && !detonated[i]) {
                sum=detonate(i, sum, bombs, detonated);
            }
        }
        return sum;
    }

    private boolean canDetonate(int[] source, int [] bomb) {
        double distance = Math.sqrt(((double)source[0]-(double)bomb[0])*((double)source[0]-(double)bomb[0]) + ((double)source[1]-(double)bomb[1])*((double)source[1]-(double)bomb[1]));
        return source[2] >= distance;
    }

    @Test
    public void test() {
        assertEquals(2, maximumDetonation(new int[][]{{2,1,3},{6,1,4}}));
        assertEquals(1, maximumDetonation(new int[][]{{1,1,5},{10,10,5}}));
        assertEquals(5, maximumDetonation(new int[][]{{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}}));
    }
}
