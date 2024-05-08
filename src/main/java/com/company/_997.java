package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _997 {

    /*Wrong Answer
91 / 92 testcases passed*/
    /*public int findJudge(int n, int[][] trust) {
        int[] trustGiven = new int[n+1];
        int[] trustReceived = new int[n+1];
        for (int[] t : trust) {
            trustReceived[t[1]]++;
            trustGiven[t[0]]++;
        }
        for (int i = 0; i < n+1; i++) {
            if (trustReceived[i]==n-1 && trustGiven[i]==0)
                return i;
        }
        return -1;
    }*/

    /*2
ms
Beats
99.85%
of users with Java*/
    public int findJudge(int n, int[][] trust) {
        if (n==1)
            return 1;
        int[] trustGiven = new int[n+1];
        int[] trustReceived = new int[n+1];
        for (int[] t : trust) {
            trustReceived[t[1]]++;
            trustGiven[t[0]]++;
        }
        for (int i = 0; i < n+1; i++) {
            if (trustReceived[i]==n-1 && trustGiven[i]==0)
                return i;
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(2, findJudge(2, new int[][]{{1,2}}));
        assertEquals(3, findJudge(3, new int[][]{{1,3},{2,3}}));
        assertEquals(-1, findJudge(3, new int[][]{{1,3}, {2,3}, {3,1}}));
    }
}
