package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class _1160 {
    /*8
    ms
            Beats
65.56%
    of users with Java*/
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        int[] freqs = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            freqs[chars.charAt(i)-'a']++;
        }
        for (int i = 0; i < words.length; i++) {
            int[] locFreqs = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                locFreqs[words[i].charAt(j)-'a']++;
            }
            boolean shouldBeAdded = true;
            for (int j = 0; j < locFreqs.length; j++) {
                if (locFreqs[j]>freqs[j]) {
                    shouldBeAdded = false;
                    break;
                }
            }
            if (shouldBeAdded)
                res+=words[i].length();
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(6, countCharacters(new String[]{"cat","bt","hat","tree"}, "atach"));
        assertEquals(10, countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr"));
    }
}
