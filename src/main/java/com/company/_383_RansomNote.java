package com.company;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;

//https://leetcode.com/problems/ransom-note/
public class _383_RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int magLen = magazine.length();
        int ranLen = ransomNote.length();
        if (magLen < ranLen)
            return false;
        int[] map = new int[26];
        int i;
        for (i = 0; i < magLen; i++) {
            map[magazine.charAt(i) - 'a']++;
        }
        for (i = 0; i < ranLen; i++) {
            int pos = ransomNote.charAt(i) - 'a';
            if (map[pos]==0)
                return false;
            map[pos]--;
        }
        return true;
    }

    //4-5 ms
   /* public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        char[] chars = magazine.toCharArray();
        for (char c : chars) {
            map[(int) c - 'a']++;
        }
        char[] magChars = ransomNote.toCharArray();
        for (char c : magChars) {
            int i = (int) c - 'a';
            if (map[i]==0)
                return false;
            map[i]--;
        }
        return true;
    }*/

    @Test
    public void test() {
        assertFalse(canConstruct("a","b"));
        assertFalse(canConstruct("aa","ab"));
        assertFalse(canConstruct("aa","aab"));
        assertFalse(canConstruct("a","b"));
        /*Your input
"a"
"b"
"aa"
"ab"
"aa"
"aab"*/
    }
}
