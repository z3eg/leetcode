package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _2486 {
    public int appendCharacters(String s, String t) {
        return 0;
    }

    @Test
    public void test() {
        assertEquals(4, appendCharacters("coaching","coding"));
        assertEquals(0, appendCharacters("abcde","a"));
        assertEquals(5, appendCharacters("z","abcde"));
    }
}
