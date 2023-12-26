package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class _455 {

    /*Wrong Answer
11 / 21 testcases passed*/
    /*public int findContentChildren(int[] g, int[] s) {
        int min= Math.min(g.length, s.length);
        Arrays.sort(g);
        Arrays.sort(s);
        int counter = 0;
        for (int i = 0; i < min; i++) {
            if (g[i]<=s[i])
                counter++;
        }
        return counter;
    }*/

    /*Wrong Answer
11 / 21 testcases passed*/
    /*public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int counter = 0;
        int l = 0;
        for (int i = 0; i < g.length; i++) {
            while (l < s.length && g[i]>s[l])
                l++;
            if (l < s.length && g[i]>=s[l])
                counter++;
        }
        return counter;
    }*/

    /*Wrong Answer
12 / 21 testcases passed*/
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int counter = 0;
        int l = 0;
        for (int i = 0; i < g.length; i++) {
            while (l < s.length && g[i]>s[l])
                l++;
            if (l < s.length && g[i]>=s[l]) {
                counter++;
                l++;
            }
        }
        return counter;
    }

    @Test
    public void test() {
        assertEquals(4, findContentChildren(new int[]{10,9,8,7,10,9,8,7}, new int[]{10,9,8,7}));
        assertEquals(1, findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        assertEquals(2, findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
}
