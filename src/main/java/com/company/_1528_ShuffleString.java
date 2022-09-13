package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/shuffle-string/
public class _1528_ShuffleString {

    public String restoreString(String s, int[] indices) {
        char[] chars = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return new String(chars);
    }

    @Test
    public void test() {
        assertEquals("leetcode", restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
        assertEquals("abc", restoreString("abc", new int[]{0,1,2}));

    }
}
