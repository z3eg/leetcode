package com.company;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class _1930 {
    /*Time Limit Exceeded
43 / 70 testcases passed*/
    public int countPalindromicSubsequence(String s) {
        int[] freqs = new int[26];
        char[] chars = s.toCharArray();
        int max = 1;
        for (char c : chars) {
            freqs[c-'a']++;
            max = Math.max(max, freqs[c-'a']);
        }
        if (max<2)
            return 0;
        int l = 0;
        while (l < s.length() && freqs[chars[l]-'a']<2)
            l++;
        int r = s.length()-1;
        while (r >= 1 && freqs[chars[r]-'a']<2)
            r--;
        s = s.substring(l,r+1);
        //do logic with s
        Set<String> res = new HashSet<>();
        chars = s.toCharArray();
        for (int i = 0; i < chars.length-2; i++) {
            for (int j = i+1; j < chars.length-1; j++) {
                for (int k = j+1; k < chars.length; k++) {
                    if (chars[i] == chars[k]) {
                        res.add(String.valueOf(chars[i])+chars[j]+chars[k]);
                    }
                }
            }
        }
        return res.size();
    }

    @Test
    public void test() {
        assertEquals(4, countPalindromicSubsequence("bbcbabad"));
        assertEquals(4, countPalindromicSubsequence("bbcbaba"));
        assertEquals(0, countPalindromicSubsequence("adc"));
        assertEquals(3, countPalindromicSubsequence("aabca"));
    }
}
