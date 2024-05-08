package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*7004. Check if a String Is an Acronym of Words
        https://leetcode.com/contest/weekly-contest-359/problems/check-if-a-string-is-an-acronym-of-words/*/
public class _W_359 {

    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length())
            return false;
        for (int i = 0; i < words.size(); i++) {
            if (s.charAt(i) != words.get(i).charAt(0))
                return false;
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(isAcronym(Arrays.asList("alice","bob","charlie"), "abc"));
        assertFalse(isAcronym(Arrays.asList("an","apple"), "a"));
        assertTrue(isAcronym(Arrays.asList("never","gonna","give","up","on","you"), "ngguoy"));
    }
}
