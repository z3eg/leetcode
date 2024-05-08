package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _1876 {
    /*1ms
    Beats 93.09%of users with Java*/
    public int countGoodSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i)!=s.charAt(i+1) && s.charAt(i)!=s.charAt(i+2) && s.charAt(i+1)!=s.charAt(i+2))
                res++;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(0, countGoodSubstrings("x"));
        assertEquals(0, countGoodSubstrings("xy"));
        assertEquals(1, countGoodSubstrings("xyz"));
        assertEquals(0, countGoodSubstrings("xyx"));
        assertEquals(0, countGoodSubstrings("xyy"));
        assertEquals(0, countGoodSubstrings("xxy"));
        assertEquals(0, countGoodSubstrings("xxyy"));
        assertEquals(0, countGoodSubstrings("yy"));
        assertEquals(1, countGoodSubstrings("xyzzaz"));
        assertEquals(4, countGoodSubstrings("aababcabc"));
    }
}
