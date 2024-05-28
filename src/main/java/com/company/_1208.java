package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        return 0;
    }

    @Test
    public void test() {
        assertEquals(3, equalSubstring("abcd","bcdf",3));
        assertEquals(1, equalSubstring("abcd","cdef",3));
        assertEquals(1, equalSubstring("abcd","acde",0));
    }
}
