package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _205 {
    /*Wrong Answer
24 / 44 testcases passed*/
    /*public boolean isIsomorphic(String s, String t) {
        int[] sFreqs = new int[26];
        int[] tFreqs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sFreqs[s.charAt(i)-'a']++;
            tFreqs[t.charAt(i)-'a']++;
        }
        Arrays.sort(sFreqs);
        Arrays.sort(tFreqs);
        return Arrays.equals(sFreqs,tFreqs);
    }*/

    /*Wrong Answer
24 / 44 testcases passed*/
    public boolean isIsomorphic(String s, String t) {
        int[] sFreqs = new int[26];
        int[] tFreqs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sFreqs[s.charAt(i)-'a']++;
            tFreqs[t.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (sFreqs[s.charAt(i)-'a']!=tFreqs[t.charAt(i)-'a'])
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(isIsomorphic("egg","add"));
        assertTrue(isIsomorphic("paper","title"));
        assertFalse(isIsomorphic("foo","bar"));
    }
}
