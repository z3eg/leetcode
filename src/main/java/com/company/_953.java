package com.company;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _953 {

    public boolean isAlienSorted(String[] words, String order) {
        int longest = 0;
        int[] lens = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            lens[i] = words[i].length();
            longest = Math.max(longest, lens[i]);
        }
        //only need to do this for similar prefixes
        for (int i = 0; i < longest; i++) {
            for (int j = 0; j < words.length - 1; j++) {
                if (lens[j] > i && lens[j+1] > i) {
                    char c1 = words[j].charAt(i);
                    char c2 = words[j+1].charAt(i);
                    if (order.indexOf(c1) > order.indexOf(c2))
                        return false;
                }
                else if (lens[j] > i && lens[j+1] <= i && words[j].contains(words[j + 1]))
                    return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        assertFalse(isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        assertFalse(isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
