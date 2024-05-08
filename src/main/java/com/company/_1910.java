package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*1910. Remove All Occurrences of a Substring
        https://leetcode.com/problems/remove-all-occurrences-of-a-substring/*/
public class _1910 {
    /*9ms
    Beats 38.06%of users with Java*/
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part,"");
        }
        return s;
    }

    @Test
    public void test() {
        assertEquals("dab", removeOccurrences("daabcbaabcbc","abc"));
        assertEquals("ab", removeOccurrences("axxxxyyyyb","xy"));
        assertEquals("ba", removeOccurrences("aabababa","aba"));
    }
}
