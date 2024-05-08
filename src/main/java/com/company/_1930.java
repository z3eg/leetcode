package com.company;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class _1930 {
    /*Time Limit Exceeded
43 / 70 testcases passed*/
    /*public int countPalindromicSubsequence(String s) {
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
    }*/

    /*13ms
    Beats 99.02%of users with Java*/
    public int countPalindromicSubsequence(String s) {
        int[][] lr = new int[26][2];
        for (int i = 0; i < 26; i++) {
            lr[i][0] = s.indexOf('a'+i);
            lr[i][1] = s.lastIndexOf('a'+i);
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res+=countUniqueSymbols(lr[i], s);
        }
        return res;
    }

    int countUniqueSymbols(int[] lr, String s) {
        if (lr[0]==-1 || lr[1] == -1 || lr[0]==lr[1])
            return 0;
        boolean[] found = new boolean[26];
        int count = 0;
        for (int i = lr[0]+1; i < lr[1]; i++) {
            char c = s.charAt(i);
            if (!found[c-'a']) {
                found[c-'a'] = true;
                count++;
                if (count==26)
                    return 26;
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(4, countPalindromicSubsequence("bbcbabad"));
        assertEquals(4, countPalindromicSubsequence("bbcbaba"));
        assertEquals(0, countPalindromicSubsequence("adc"));
        assertEquals(3, countPalindromicSubsequence("aabca"));
    }
}
