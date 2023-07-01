package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*2185. Counting Words With a Given Prefix
        https://leetcode.com/problems/counting-words-with-a-given-prefix/*/
public class _2185 {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String word : words) {
            if (word.startsWith(pref))
                res++;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(2, prefixCount(new String[]{"pay","attention","practice","attend"}, "at"));
        assertEquals(0, prefixCount(new String[]{"leetcode","win","loops","success"}, "at"));
    }
}
