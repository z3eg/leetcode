package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1578 {

    /*12
    ms
            Beats
14.91%
    of users with Java*/
    public int minCost(String colors, int[] neededTime) {
        int p = 0;
        int res = 0;
        while (p<colors.length()) {
            if (p<colors.length()-1 && colors.charAt(p)==colors.charAt(p+1)) {
                int sum = 0;
                sum+=neededTime[p];
                int max = neededTime[p];
                p++;
                while (p<colors.length() && colors.charAt(p)==colors.charAt(p-1)) {
                    max = Math.max(neededTime[p], max);
                    sum+=neededTime[p];
                    p++;
                }
                res+=sum-max;
            }
            else {
                p++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(55, minCost("aaabbb", new int[]{8,111,27,4,16,75}));
        assertEquals(55, minCost("aaacbbb", new int[]{8,111,27,30,4,16,75}));
        assertEquals(55, minCost("caaacbbbc", new int[]{4,8,111,27,30,4,16,75,33}));
        assertEquals(0, minCost("a", new int[]{1}));
        assertEquals(1, minCost("aa", new int[]{1,7}));
        assertEquals(1, minCost("aa", new int[]{8,1}));
        assertEquals(3, minCost("aaa", new int[]{8,1,2}));
        assertEquals(19, minCost("aaa", new int[]{8,11,27}));
        assertEquals(35, minCost("aaa", new int[]{8,111,27}));
        assertEquals(3, minCost("abaac", new int[]{1,2,3,4,5}));
        assertEquals(0, minCost("abc", new int[]{1,2,3}));
        assertEquals(2, minCost("aabaa", new int[]{1,2,3,4,1}));
    }
}
