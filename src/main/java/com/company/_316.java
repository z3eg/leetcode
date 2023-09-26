package com.company;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/*https://leetcode.com/problems/remove-duplicate-letters/description/?envType=daily-question&envId=2023-09-26
316. Remove Duplicate Letters*/
public class _316 {
    public String removeDuplicateLetters(String s) {
        Queue[] qs = new Queue[26];
        for (int i = 0; i < 26; i++) {
            qs[i] = new LinkedList<Integer>();
        }
        for (char c : s.toCharArray()) {
//            qs[c-'a']++;
        }
        for (int i = 25; i >= 0; i--) {

        }
        return "";
    }

    @Test
    public void test() {
        assertEquals("abc", removeDuplicateLetters("bcabc"));
        assertEquals("acdb", removeDuplicateLetters("cbacdcbc"));
    }
}
