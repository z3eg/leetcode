package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _345 {

/*    Runtime Error
10 / 480 testcases passed*/
    /*public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length()-1;
        while (l<r) {
            while (!isVowel(chars[l])) {
                l++;
            }
            while (!isVowel(chars[r])) {
                r--;
            }
            if (l < r) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }*/

    /*2
    ms
            Beats
99.38%
    of users with Java*/
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length()-1;
        while (l<r) {
            while (l < s.length() && !isVowel(chars[l])) {
                l++;
            }
            while (r > -1 && !isVowel(chars[r])) {
                r--;
            }
            if (l < r) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }

    boolean isVowel(char c) {
        return (c=='A' || c=='E' || c=='O' || c=='U' || c=='I' || c=='a' || c=='e' || c=='o' || c=='u' || c=='i');
    }

    @Test
    public void test() {
        assertEquals("holle", reverseVowels("hello"));
        assertEquals("leetcode", reverseVowels("leotcede"));
        assertEquals("aA", reverseVowels("Aa"));
        assertEquals("ao", reverseVowels("oa"));
        assertEquals("aa", reverseVowels("aa"));
        assertEquals("aOa", reverseVowels("aOa"));
        assertEquals("aOA", reverseVowels("AOa"));
        assertEquals(".,", reverseVowels(".,"));
    }
}
