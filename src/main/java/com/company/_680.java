package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _680 {

    /*Wrong Answer
377 / 471 testcases passed*/
    public boolean validPalindrome(String s) {
        int[] freqs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i)-'a']++;
        }
        int odds = 0;
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i]%2!=0)
                odds++;
        }
        return odds<=2;
    }

    @Test
    public void test() {
        assertTrue(validPalindrome("aba"));
        assertTrue(validPalindrome("abca"));
        assertFalse(validPalindrome("abc"));
    }
}
