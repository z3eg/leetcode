package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _409 {

    /*Runtime Error
26 / 95 testcases passed*/
    /*public int longestPalindrome(String s) {
        int[] freqs = new int[27];
        for (char c : s.toCharArray()) {
            freqs[c-'a']++;
        }
        int res = 0;
        int maxOdd = 0;
        for (int f : freqs) {
            if (f%2==0)
                res+=f;
            else
                maxOdd = Math.max(maxOdd, f);
        }
        return res+maxOdd;
    }*/

    /*Runtime Error
35 / 95 testcases passed*/
    /*public int longestPalindrome(String s) {
        int[] freqs = new int[52];
        for (char c : s.toCharArray()) {
            freqs[c-'A']++;
        }
        int res = 0;
        int maxOdd = 0;
        for (int f : freqs) {
            if (f%2==0)
                res+=f;
            else
                maxOdd = Math.max(maxOdd, f);
        }
        return res+maxOdd;
    }*/

    /*Wrong Answer
49 / 95 testcases passed*/
    /*public int longestPalindrome(String s) {
        int[] freqs = new int[60];
        for (char c : s.toCharArray()) {
            freqs[c-'A']++;
        }
        int res = 0;
        int maxOdd = 0;
        for (int f : freqs) {
            if (f%2==0)
                res+=f;
            else
                maxOdd = Math.max(maxOdd, f);
        }
        return res+maxOdd;
    }*/

    /*1
    ms
            Beats
100.00%
    of users with Java*/
    public int longestPalindrome(String s) {
        int[] freqs = new int[60];
        for (char c : s.toCharArray()) {
            freqs[c-'A']++;
        }
        int res = 0;
        boolean hasOdd = false;
        for (int f : freqs) {
            if (f%2!=0)
                hasOdd = true;
            res+=f-f%2;
        }
        return res+(hasOdd?1:0);
    }

    @Test
    public void test() {
        assertEquals(7, longestPalindrome("abccccdd"));
        assertEquals(1, longestPalindrome("a"));
        assertEquals(3, longestPalindrome("aaa"));
        assertEquals(4, longestPalindrome("aaaa"));
        assertEquals(4, longestPalindrome("AAAA"));
        assertEquals(55, longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));
    }
}
