package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _345 {
    public String reverseVowels(String s) {

    }

    @Test
    public void test() {
        assertEquals("holle", reverseVowels("hello"));
        assertEquals("leetcode", reverseVowels("leotcede"));
    }
}
