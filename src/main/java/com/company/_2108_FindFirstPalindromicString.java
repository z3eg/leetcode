package com.company;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
public class _2108_FindFirstPalindromicString {

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word))
                return word;
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length()-1;
        while (left<=right) {
            if (word.charAt(left)!=word.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void testPal() {
        assertTrue(isPalindrome("abadaba"));
        assertTrue(isPalindrome("abaddaba"));
        assertFalse(isPalindrome("abadbba"));
        assertTrue(isPalindrome("a"));
    }
}
