package com.company;

/*https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
1880. Check if Word Equals Summation of Two Words*/

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class _1880 {
    /*0ms
    Beats 100.00%of users with Java*/
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        char[] f = new char[firstWord.length()];
        char[] s = new char[secondWord.length()];
        char[] t = new char[targetWord.length()];
        for (int i = 0; i < firstWord.length(); i++) {
            f[i] = '0';
            f[i]+=(firstWord.charAt(i)-'a');
        }
        for (int i = 0; i < secondWord.length(); i++) {
            s[i] = '0';
            s[i]+=(secondWord.charAt(i)-'a');
        }
        for (int i = 0; i < targetWord.length(); i++) {
            t[i] = '0';
            t[i]+=(targetWord.charAt(i)-'a');
        }
        int first = Integer.parseInt(new String(f));
        int second = Integer.parseInt(new String(s));
        int target = Integer.parseInt(new String(t));
        return (first+second==target);
    }

    @Test
    public void test() {
        assertTrue(isSumEqual("acb","cba","cdb"));
        assertFalse(isSumEqual("aaa","a","aab"));
        assertTrue(isSumEqual("aaa","a","aaa"));
    }
}
