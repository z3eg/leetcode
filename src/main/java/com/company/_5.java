package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class _5 {

    /*28ms
    Beats 43.48%of users with Java*/
    public String longestPalindrome(String s) {
        if (s.length()==1)
            return s;
        if (s.length()==2)
            return (s.charAt(0)==s.charAt(1)?s:s.substring(0,1));
        int maxLen = 0;
        int maxL = 0;
        int maxR = 0;
        for (int i = 1; i < s.length()-1; i++) {
            int r = i;
            while(r < s.length() && s.charAt(i)==s.charAt(r))
                r++;
            int l = i;
            while(l >= 0 && s.charAt(i)==s.charAt(l))
                l--;
            while (l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r))
            {
                l--;
                r++;
            }
            int curLen = r-l;
            if (curLen > maxLen) {
                maxLen = curLen;
                maxL = l+1;
                maxR = r-1;
            }
        }
        return s.substring(maxL, maxR+1);
    }

    @Test
    public void test() {
        assertEquals("baaaaab", longestPalindrome("zbaaaaabs"));
        assertEquals("baasaab", longestPalindrome("zbaasaabs"));
        assertEquals("baaaab", longestPalindrome("zbaaaabs"));
        assertEquals("aaaa", longestPalindrome("aaaa"));
        assertEquals("aaa", longestPalindrome("aaa"));
        assertEquals("aa", longestPalindrome("aa"));
        assertEquals("aa", longestPalindrome("aab"));
        assertTrue("bab".equals(longestPalindrome("babad")) || "aba".equals(longestPalindrome("babad")));
        assertEquals("bb", longestPalindrome("cbbd"));
        assertEquals("b", longestPalindrome("b"));
        assertEquals("aa", longestPalindrome("baa"));
        assertEquals("a", longestPalindrome("ab"));
    }
}
