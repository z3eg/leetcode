package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*2586. Count the Number of Vowel Strings in Range
        https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/*/
public class _2586 {

    /*1ms
    Beats 100.00%of users with Java*/
    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (isVowel(words[i]))
                res++;
        }
        return res;
    }

    boolean isVowel(String s) {
        return (s.startsWith("a") ||s.startsWith("e") ||s.startsWith("o") ||s.startsWith("i") ||s.startsWith("u")) &&
                (s.endsWith("a") ||s.endsWith("e") ||s.endsWith("o") ||s.endsWith("i") ||s.endsWith("u"));
    }

    @Test
    public void test() {
        assertEquals(2, vowelStrings(new String[]{"are","amy","u"}, 0, 2));
        assertEquals(3, vowelStrings(new String[]{"hey","aeo","mu","ooo","artro"}, 1, 4));
    }
}
