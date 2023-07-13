package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/*1332. Remove Palindromic Subsequences
        https://leetcode.com/problems/remove-palindromic-subsequences/*/
public class _1332 {

    /*Runtime
    0 ms
    Beats
    100%
    */
    public int removePalindromeSub(String s) {
        return isPalindrome(s)?1:2;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(isPalindrome("abba"));
        assertTrue(isPalindrome("ababa"));
        assertTrue(isPalindrome("abaaaaba"));
        assertTrue(isPalindrome("aaaaaa"));
        assertTrue(isPalindrome("b"));
        assertFalse(isPalindrome("ab"));
        assertFalse(isPalindrome("abab"));
        assertFalse(isPalindrome("abbbbb"));
    }

    @Test
    public void test() {
        assertEquals(2, removePalindromeSub("abb"));
        assertEquals(1, removePalindromeSub("ababa"));
        assertEquals(2, removePalindromeSub("aababaaa"));
        assertEquals(2, removePalindromeSub("aabbabaaa"));
        assertEquals(2, removePalindromeSub("aabbababaa"));
        assertEquals(2, removePalindromeSub("aaaabbbaaaaaaa"));
    }

}
