package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*392. Is Subsequence
        https://leetcode.com/problems/is-subsequence/description/?envType=daily-question&envId=2023-09-22*/
public class _392 {


    /*0ms
    Beats 100.00%of users with Java*/
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen > tLen)
            return false;
        char[] tArr = t.toCharArray();
        int p = 0;
        for (char c : s.toCharArray()) {
            boolean contains = false;
            for (int i = p; i < tLen; i++) {
                if (tArr[i] == c) {
                    p = i+1;
                    contains = true;
                    break;
                }
            }
            if (!contains)
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        assertFalse(isSubsequence("aaaaaa","bbaaaa"));
        assertTrue(isSubsequence("abc","abc"));
        assertTrue(isSubsequence("abb","ahbbc"));
        assertTrue(isSubsequence("","ahbgdc"));
        assertTrue(isSubsequence("abc","ahbgdc"));
        assertFalse(isSubsequence("axc","ahbgdc"));
        assertFalse(isSubsequence("axc",""));
    }
}
