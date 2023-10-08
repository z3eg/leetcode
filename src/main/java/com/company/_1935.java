package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*1935. Maximum Number of Words You Can Type
        https://leetcode.com/problems/maximum-number-of-words-you-can-type/description/*/
public class _1935 {

    /*2ms
    Beats 94.63%of users with Java*/
    /*public int canBeTypedWords(String text, String brokenLetters) {
        int res = 0;
        String[] words = text.split(" ");
        char[] lets = brokenLetters.toCharArray();
        foo: for (String word : words) {
            for (char c : lets) {
                if (word.indexOf(c)!=-1)
                    continue foo;
            }
            res++;
        }
        return res;
    }*/

    /*2ms
    Beats 94.63%of users with Java*/
    public int canBeTypedWords(String text, String brokenLetters) {
        int res = 0;
        String[] words = text.split(" ");
        char[] lets = brokenLetters.toCharArray();
        for (String word : words) {
            boolean canBeTyped = true;
            for (char c : lets) {
                if (word.indexOf(c)!=-1) {
                    canBeTyped = false;
                    break;
                }
            }
            if (canBeTyped)
                res++;
        }
        return res;
    }

    @Test
    public void test() {
        assertEquals(1, canBeTypedWords("hello world", "ad"));
        assertEquals(1, canBeTypedWords("leet code", "lt"));
        assertEquals(0, canBeTypedWords("leet code", "e"));
    }
}
