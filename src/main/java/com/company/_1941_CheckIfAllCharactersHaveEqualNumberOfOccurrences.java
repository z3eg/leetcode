package com.company;

import org.junit.Test;

//https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
public class _1941_CheckIfAllCharactersHaveEqualNumberOfOccurrences {
    public boolean areOccurrencesEqual(String s) {
        int[] freqs = new int[26];
        for (char c : s.toCharArray()) {
            freqs[c-'a']++;
        }
        int pos = 0;
        while (freqs[pos]==0) {
            pos++;
        }
        int notZeroFreq = freqs[pos];
        int length = freqs.length;
        for (int i = pos+1; i < length; i++) {
            if (freqs[i]!=0 && freqs[i]!=notZeroFreq)
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        areOccurrencesEqual("aaabb");
    }
}
