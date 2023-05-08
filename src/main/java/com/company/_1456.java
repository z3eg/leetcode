package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
        1456. Maximum Number of Vowels in a Substring of Given Length*/
public class _1456 {
    public int maxVowels(String s, int k) {
        int cur = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                cur++;
            }
        }
        int max = cur;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i-k)))
                cur--;
            if (isVowel(s.charAt(i)))
                cur++;
            max = Math.max(max,cur);
        }
        return max;
    }

    boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    @Test
    public void test() {
        assertEquals(1, maxVowels("a", 1));
        assertEquals(3, maxVowels("aoe", 3));
        assertEquals(1, maxVowels("abc", 3));
        assertEquals(3, maxVowels("abciiidef", 3));
        assertEquals(2, maxVowels("aeiou", 2));
        assertEquals(2, maxVowels("leetcode", 3));
    }
}
