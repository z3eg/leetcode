package com.company;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/*1641. Count Sorted Vowel Strings
        https://leetcode.com/problems/count-sorted-vowel-strings/*/
public class _1641 {
    public int countVowelStrings(int n) {
        LinkedList<String> strings = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        char[] lets = new char[]{'a','e','i','o','u'};
        /*while(sb.length() < n) {
            sb.append()
        }*/
        return 0;
    }

    @Test
    public void test() {
        assertEquals(5, countVowelStrings(1));
        assertEquals(15, countVowelStrings(2));
        assertEquals(66045, countVowelStrings(33));
    }
}
