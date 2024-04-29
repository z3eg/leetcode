package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _541 {

    /*Wrong Answer
42 / 60 testcases passed*/
    /*public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int i = 0;
        while(i+k-1 < chars.length) {
            reverse(chars, i, i+k-1);
            i+=2*k;
        }
        return new String(chars);
    }

    void reverse(char[] s, int start, int end) {
        for (int i = 0; i <= (end-start)/2 ; i++) {
            char c = s[start+i];
            s[start+i] = s[end-i];
            s[end-i] = c;
        }
    }*/

    /*0
    ms
    Beats
    100.00%
    of users with Java*/
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int i = 0;
        while(i < chars.length) {
            reverse(chars, i, i+k-1);
            i+=2*k;
        }
        return new String(chars);
    }

    void reverse(char[] s, int start, int end) {
        if (end >= s.length)
            end = s.length-1;
        for (int i = 0; i <= (end-start)/2 ; i++) {
            char c = s[start+i];
            s[start+i] = s[end-i];
            s[end-i] = c;
        }
    }

    @Test
    public void test() {
        assertEquals("gfedcba", reverseStr("abcdefg", 8));
        assertEquals("a", reverseStr("a", 1));
        assertEquals("a", reverseStr("a", 2));
        assertEquals("ba", reverseStr("ab", 2));
        assertEquals("bac", reverseStr("abc", 2));
        assertEquals("cbad", reverseStr("abcd", 3));
        assertEquals("bacdfeg", reverseStr("abcdefg", 2));
        assertEquals("bacd", reverseStr("abcd", 2));
    }
}
