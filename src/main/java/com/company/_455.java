package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _455 {

    /*Wrong Answer
11 / 21 testcases passed*/
    public int findContentChildren(int[] g, int[] s) {
        int min= Math.min(g.length, s.length);
        Arrays.sort(g);
        Arrays.sort(s);
        int counter = 0;
        for (int i = 0; i < min; i++) {
            if (g[i]<=s[i])
                counter++;
        }
        return counter;
    }

    @Test
    public void test() {
        assertEquals(1, findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        assertEquals(2, findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
}
