package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    /*public boolean isIsomorphic(String s, String t) {
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
    }*/

    /*8
    ms
            Beats
72.59%
    of users with Java*/
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicLeft(s,t) && isIsomorphicLeft(t,s);
    }

    public boolean isIsomorphicLeft(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character sc = map.get(s.charAt(i));
            if (sc == null) {
                map.put(s.charAt(i), t.charAt(i));
            }
            else {
                if (sc!=t.charAt(i))
                    return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertFalse(isIsomorphic("bar","foo"));
        assertFalse(isIsomorphic("foo","bar"));
        assertTrue(isIsomorphic("egg","add"));
        assertTrue(isIsomorphic("paper","title"));
    }
}
