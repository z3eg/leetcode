package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class _242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() !=t.length()) return false;
        int[] sArr = new int[26];
        for (char c : s.toCharArray()) {
            sArr[c-97]++;
        }
        for (char c : t.toCharArray()) {
            sArr[c-97]--;
        }
        return Arrays.equals(sArr,new int[26]);
    }

    @Test
    public void test() {
        Assertions.assertTrue(isAnagram("anagram", "nagaram"));
        Assertions.assertFalse(isAnagram("rat", "car"));
    }

}
