package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*646. Maximum Length of Pair Chain
        https://leetcode.com/problems/maximum-length-of-pair-chain/*/
public class _646 {
    /*50ms
Beats 16.58%of users with Java*/
    public int findLongestChain(int[][] pairs) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < pairs.length-1; i++) {
                if (pairs[i][1] > pairs[i+1][1]) {
                    sorted = false;
                    int[] tmp = pairs[i];
                    pairs[i] = pairs[i+1];
                    pairs[i+1] = tmp;
                }
            }
        }
        int cur = 1;
        int[] lastLink = pairs[0];
        for (int j = 1; j < pairs.length; j++) {
            if (pairs[j][0] > lastLink[1]) {
                cur++;
                lastLink = pairs[j];
            }
        }
        return cur;
    }

    @Test
    public void test() {
        assertEquals(1, findLongestChain(new int[][]{{1,2}}));
        assertEquals(1, findLongestChain(new int[][]{{1,2},{-1,3}}));
        assertEquals(1, findLongestChain(new int[][]{{1,2},{2,3}}));
        assertEquals(2, findLongestChain(new int[][]{{1,2},{3,4}}));
        assertEquals(2, findLongestChain(new int[][]{{3,4},{1,2}}));
        assertEquals(2, findLongestChain(new int[][]{{1,2},{2,3},{3,4}}));
        assertEquals(3, findLongestChain(new int[][]{{1,2},{7,8},{4,5}}));
    }
}
