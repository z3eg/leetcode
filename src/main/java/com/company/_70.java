package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _70 {
    /*Time Limit Exceeded
    21 / 45 testcases passed*/
    public int climbStairs(int n) {
        return climb(n, 0, 0);
    }

    int climb(int n, int cur, int res) {
        if (cur==n) {
            return res+1;
        }
        if (cur>n)
            return res;
        res = climb(n, cur+1, res);
        res = climb(n, cur+2, res);
        return res;
    }

    @Test
    public void test() {
        assertEquals(1, climbStairs(1));
        assertEquals(2, climbStairs(2));
        assertEquals(3, climbStairs(3));
    }
}
