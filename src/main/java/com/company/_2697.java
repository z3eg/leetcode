package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*2697. Lexicographically Smallest Palindrome
https://leetcode.com/problems/lexicographically-smallest-palindrome/*/
public class _2697 {

    //10ms, 83.33%
    /*public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int charLen = chars.length;
        for (int i = 0; i < charLen / 2; i++) {
            if (chars[i] < chars[charLen -i-1]) {
                chars[charLen-i-1] = chars[i];
            }
            else {
                chars[i] = chars[charLen-i-1];
            }
        }
        return new String(chars);
    }*/

    //9ms, 100%
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int charLen = chars.length;
        int l = 0;
        int r = charLen - 1;
        while (l<r) {
            if (chars[l] < chars[r]) {
                chars[r] = chars[l];
            }
            else {
                chars[l] = chars[r];
            }
            l++;
            r--;
        }
        return new String(chars);
    }

    @Test
    public void test() {
        assertEquals("efcfe", makeSmallestPalindrome("egcfe"));
        assertEquals("abba", makeSmallestPalindrome("abcd"));
        assertEquals("neven", makeSmallestPalindrome("seven"));
    }

}
