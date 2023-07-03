package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//https://leetcode.com/problems/buddy-strings/
public class _859_BuddyStrings {

    /*Runtime
    1 ms
    Beats
    99.2%*/
    public boolean buddyStrings(String s, String goal) {
        int sLen = s.length();
        if (sLen !=goal.length())
            return false;
        if (sLen < 2)
            return false;
        int[] freqs = new int[26];
        if (s.equals(goal)) {
            for (char c : s.toCharArray()) {
                freqs[c-97]++;
                if (freqs[c-97]>1)
                    return true;
            }
            return false;
        }
        else {
            char sDisc = '1';
            char goalDisc = '1';
            int discs = 0;
            for (int i = 0; i < sLen; i++) {
                if (s.charAt(i)!=goal.charAt(i)) {
                    discs++;
                    if (discs > 2)
                        return false;
                    if (discs == 1 ) {
                        sDisc = s.charAt(i);
                        goalDisc = goal.charAt(i);
                    }
                    if (discs == 2) {
                        if (!(sDisc == goal.charAt(i) && goalDisc == s.charAt(i)))
                            return false;
                    }
                }
            }
            return discs==2;
        }
    }

    @Test
    public void test() {
        assertFalse(buddyStrings("abac","abad"));
        assertFalse(buddyStrings("a","b"));
        assertFalse(buddyStrings("a","a"));
        assertTrue(buddyStrings("abba","baba"));
        assertTrue(buddyStrings("abba","aabb"));
        assertTrue(buddyStrings("ab","ba"));
        assertTrue(buddyStrings("aa","aa"));
        assertTrue(buddyStrings("aaaa","aaaa"));
        assertFalse(buddyStrings("ab","ab"));
    }
}
