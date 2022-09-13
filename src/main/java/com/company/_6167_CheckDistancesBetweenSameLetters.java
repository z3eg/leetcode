package com.company;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//https://leetcode.com/contest/weekly-contest-309/problems/check-distances-between-same-letters/
public class _6167_CheckDistancesBetweenSameLetters {

    public boolean checkDistances(String s, int[] distance) {
        int slen = s.length();
        for (int i = 0; i < slen; i++) {
            char c = s.charAt(i);
            int pos = c - 'a';
            int leftPos = i - distance[pos] - 1;
            int rightPos = i + distance[pos] + 1;
            if (!((leftPos>=0 && s.charAt(leftPos)==c) || (rightPos< slen && s.charAt(rightPos)==c)))
                return false;
        }
        return true;
    }


    @Test
    public void test() {
        assertTrue(checkDistances("abaccb", new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        assertFalse(checkDistances("aa", new int[]{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }
}
