package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*1347. Minimum Number of Steps to Make Two Strings Anagram
        https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/*/
public class _1347 {
    /*Runtime
    9 ms
    Beats
    93.86%*/
    public int minSteps(String s, String t) {
        int[] charFreqs = new int[26];
        for (char c : s.toCharArray()) {
            charFreqs[c-97]++;
        }
        for (char c : t.toCharArray()) {
            charFreqs[c-97]--;
        }
        int sum = 0;
        for (int i = 0; i < charFreqs.length; i++) {
            sum+=Math.abs(charFreqs[i]);
        }
        return sum/2;
    }

    @Test
    public void test() {
        assertEquals(1, minSteps("bab", "aba"));
        assertEquals(5, minSteps("leetcode", "practice"));
        assertEquals(0, minSteps("anagram", "mangaar"));
    }
}
