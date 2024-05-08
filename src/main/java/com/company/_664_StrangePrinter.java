package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/strange-printer/
public class _664_StrangePrinter {
    //51/200 TC
    /*public int strangePrinter(String s) {
        return Math.min(strangePrinter(s, 0, 0, s.length()-1, true),
                strangePrinter(s, 0, 0, s.length()-1, false));
    }

    int strangePrinter(String s, int curIterations, int l, int r, boolean goRight) {
        if (l>r) {
            return curIterations;
        }
        System.out.println("iterations: " + curIterations + "\t" + s.substring(l,r+1));
        char curL = goRight?s.charAt(l):s.charAt(r);
        while (l < s.length() && s.charAt(l)==curL) {
            l++;
        }
        while (r >=0 && s.charAt(r)==curL) {
            r--;
        }
        curIterations++;
        return Math.min(strangePrinter(s, curIterations, l, r, true), strangePrinter(s, curIterations, l, r, false));
    }*/

    public int strangePrinter(String s) {
        return strangePrinter(s, 0, 0, s.length()-1);
    }

    int strangePrinter(String s, int curIterations, int l, int r) {
        if (l>r) {
            return curIterations;
        }
        System.out.println("iterations: " + curIterations + "\t" + s.substring(l,r+1));
        char curL = s.charAt(l);
        char curR = s.charAt(r);
        int curLPos = l;
        int curRPos = r;
        while (l < s.length() && s.charAt(l)==curL) {
            l++;
        }
        while (r >=0 && s.charAt(r)==curR) {
            r--;
        }
        curIterations++;
        if (curL==curR)
            return strangePrinter(s, curIterations, l, r);
        if (curR == s.charAt(l))
            return strangePrinter(s, curIterations, l, curRPos);
        return strangePrinter(s, curIterations, curLPos, r);
    }

    @Test
    public void test() {
        assertEquals(19, strangePrinter("baacdddaaddaaaaccbddbcabdaabdbbcdcbbbacbddcabcaaa"));
        assertEquals(4, strangePrinter("ababc"));
        assertEquals(3, strangePrinter("aababaa"));
        assertEquals(3, strangePrinter("aaaaaaaabca"));
        assertEquals(3, strangePrinter("aabcbaa"));
        assertEquals(2, strangePrinter("aaabbb"));
        assertEquals(2, strangePrinter("aba"));
    }
}
