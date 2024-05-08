package com.company;

import org.junit.jupiter.api.Test;
import scala.Int;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//7005. Check if Strings Can be Made Equal With Operations II
//https://leetcode.com/contest/biweekly-contest-112/problems/check-if-strings-can-be-made-equal-with-operations-ii/
public class BW_112_2 {
    public boolean checkStrings(String s1, String s2) {
        /*Set<Character> evens = new HashSet<>();
        Set<Character> odds = new HashSet<>();*/
        int[] s1EvenFreqs = new int[26];
        int[] s1OddFreqs = new int[26];
        int[] s2EvenFreqs = new int[26];
        int[] s2OddFreqs = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (i%2==0) {
//                evens.add(c1);
                s1EvenFreqs[c1-'a']++;
                s2EvenFreqs[c2-'a']++;
            }
            else {
//                odds.add(c1);
                s1OddFreqs[c1-'a']++;
                s2OddFreqs[c2-'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (s1EvenFreqs[i]!=s2EvenFreqs[i])
                return false;
            if (s1OddFreqs[i]!=s2OddFreqs[i])
                return false;
        }
        /*for (int i = 0; i < s2.length(); i++) {
            if (i%2==0) {
                if (!evens.contains(s2.charAt(i)))
                    return false;
            }
            else
                if (!odds.contains(s2.charAt(i)))
                    return false;
        }*/
        return true;
    }

    @Test
    public void test() {
        assertFalse(checkStrings("iovkcosxlypaqaaco", "ioaxvyaclaqkocsop"));
        assertFalse(checkStrings("cabdab", "abadba"));
        assertFalse(checkStrings("abadba", "cabdab"));
        assertTrue(checkStrings("abcdba", "cabdab"));
        assertFalse(checkStrings("abe", "bea"));
    }
}
