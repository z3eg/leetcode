package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*https://leetcode.com/problems/count-prefixes-of-a-given-string/description/
2255. Count Prefixes of a Given String*/
public class _2255 {

    /*0ms
    Beats 100.00%of users with Java*/
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for (String w : words) {
            if (s.startsWith(w))
                res++;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(3, countPrefixes(new String[]{"a","b","c","ab","bc","abc"}, "abc"));
        assertEquals(2, countPrefixes(new String[]{"a","a"}, "aa"));
    }
}
