package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/implement-strstr/
public class _28_Implement_strStr {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        return haystack.indexOf(needle);
    }

    @Test
    public void test() {
        assertEquals(2, strStr("hello",  "ll"));
        assertEquals(-1, strStr("aaaaa",  "bba"));
    }
}
