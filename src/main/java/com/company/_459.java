package com.company;

import java.util.Objects;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*459. Repeated Substring Pattern
        https://leetcode.com/problems/repeated-substring-pattern/*/
public class _459 {
    /*6ms
    Beats 97.53%of users with Java*/
    public boolean repeatedSubstringPattern(String s) {
        int sLen = s.length();
        for (int i = sLen/2 ; i > 0; i--) {
            if (sLen%i==0) {
                boolean repeatable = true;
                int parts = sLen / i;
                for (int j = 1; j < parts; j++) {
                    if (!(s.substring(0, i).equals(s.substring(i*j, i*j+i)))) {
                        repeatable = false;
                        break;
                    }
                }
                if (repeatable)
                    return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        assertFalse(repeatedSubstringPattern("a"));
        assertTrue(repeatedSubstringPattern("aaaaaaaaaa"));
        assertTrue(repeatedSubstringPattern("aaabaaab"));
        assertTrue(repeatedSubstringPattern("abab"));
        assertFalse(repeatedSubstringPattern("aba"));
        assertFalse(repeatedSubstringPattern("ab"));
        assertFalse(repeatedSubstringPattern("aaabbb"));
        assertTrue(repeatedSubstringPattern("abcabcabcabc"));
    }
}
