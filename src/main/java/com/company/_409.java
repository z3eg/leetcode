package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _409 {

    /*Runtime Error
26 / 95 testcases passed*/
    public int longestPalindrome(String s) {
        int[] freqs = new int[27];
        for (char c : s.toCharArray()) {
            freqs[c-'a']++;
        }
        int res = 0;
        int maxOdd = 0;
        for (int f : freqs) {
            if (f%2==0)
                res+=f;
            else
                maxOdd = Math.max(maxOdd, f);
        }
        return res+maxOdd;
    }

    @Test
    public void test() {
        assertEquals(7, longestPalindrome("abccccdd"));
        assertEquals(1, longestPalindrome("a"));
        assertEquals(3, longestPalindrome("aaa"));
        assertEquals(4, longestPalindrome("aaaa"));
    }
}
