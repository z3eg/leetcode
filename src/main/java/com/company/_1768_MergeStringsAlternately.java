package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/merge-strings-alternately/
public class _1768_MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        char[] resChar = new char[len1+len2];
        if (len1>len2) {
            for (int i = 0; i < len2; i++) {
                resChar[2*i] = word1.charAt(i);
                resChar[2*i+1] = word2.charAt(i);
            }
            for (int i = len2; i < len1; i++) {
                resChar[i+len2] = word1.charAt(i);
            }
        }
        else {
            for (int i = 0; i < len1; i++) {
                resChar[2*i] = word1.charAt(i);
                resChar[2*i+1] = word2.charAt(i);
            }
            for (int i = len1; i < len2; i++) {
                resChar[i+len1] = word2.charAt(i);
            }
        }
        return new String(resChar);
    }

    @Test
    public void test() {
        assertEquals("apbqcr", mergeAlternately("abc","pqr"));
        assertEquals("apbqrs", mergeAlternately("ab","pqrs"));
        assertEquals("apbqcd", mergeAlternately("abcd","pq"));
    }
}
